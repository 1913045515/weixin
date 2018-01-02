var app = getApp();
// pages/order/downline.js
Page({
  data:{
    itemData:{},
    userId:0,
    paytype:'weixin',//0线下1微信
    remark:'',
    cartId:0,
    addrId:0,//收货地址//测试--
    btnDisabled:false,
    productData:[],
    address:{},
    total:0,
    vprice:0,
    vid:0,
    addemt:1,
    vou:[]
  },
  onLoad:function(options){
    var userId="";
    var uid = userId;
    this.setData({
      cartId: options.cartId,
      userId: uid
    });
    this.loadProductDetail();
  },
  loadProductDetail:function(){
    var that = this;
    wx.request({
      url: app.server.hostUrl + '/Api/Payment/buyCart',
      method:'post',
      data: {
        cart_id: that.data.cartId,
        uid: that.data.userId,
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          addemt: res.data.addemt,
          productData:res.data.productList,
          total: res.data.price,
          vou: res.data.vouList,
          address: res.data.address,
          remark: res.data.remark
        });
      },
    });
  },

  remarkInput:function(e){
    this.setData({
      remark: e.detail.value,
    })
  },

 //选择优惠券
  getvou:function(e){
    var vid = e.currentTarget.dataset.id;
    var price = e.currentTarget.dataset.price;
    var zprice = this.data.vprice;
    var cprice = parseFloat(zprice) - parseFloat(price);
    this.setData({
      total: cprice,
      vid: vid
    })
  }, 

//微信支付
  createProductOrderByWX:function(e){
    this.setData({
      paytype: 'weixin',
    });

    this.createProductOrder();
  },

  //线下支付
  createProductOrderByXX:function(e){
    this.setData({
      paytype: 'cash',
    });
    wx.showToast({
      title: "线下支付开通中，敬请期待!",
      duration: 3000
    });
    return false;
    this.createProductOrder();
  },

  //确认订单
  createProductOrder:function(){
    this.setData({
      btnDisabled:false,
    })

    //创建订单
    var that = this;
    wx.request({
      url: app.server.hostUrl + '/Api/Order/createOrder',
      method:'post',
      data: {
        openId: app.server.appId
        // uid: that.data.userId,
        // cart_id: that.data.cartId,
        // type:that.data.paytype,
        // aid: that.data.addrId,//地址的id
        // remark: that.data.remark,//用户备注
        // price: that.data.total,//总价
        // vid: that.data.vid,//优惠券ID
      },
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        //--init data        
        var data = res.data;
        if(data.status == 1){
          //创建订单成功
          if(data.payType == 'cash'){
              wx.showToast({
                 title:"请自行联系商家进行发货!",
                 duration:3000
              });
              return false;
          }
          if(data.payType == 'weixin'){
            //微信支付
            that.wxpay(data);
          }
        }else{
          wx.showToast({
            title:"下单失败!",
            duration:2500
          });
        }
      },
      fail: function (e) {
        wx.showToast({
          title: '网络异常！err:createProductOrder',
          duration: 2000
        });
      }
    });
  },
  
  //调起微信支付
  wxpay: function(order){
      wx.request({
        url: app.server.hostUrl + '/Api/Payment/payment',
        method: 'post',
        data: {
          orderId:order.orderId,
          userId:app.server.userId
        },
        header: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }, // 设置请求的 header
        success: function(res){
          if(res.data.status==1){
            wx.requestPayment({
              timeStamp: order.timeStamp,
              nonceStr: order.nonceStr,
              package: order.package,
              signType: 'MD5',
              paySign: order.paySign,
              success: function(res){
                wx.showToast({
                  title:"支付成功!",
                  duration:2000,
                });
                setTimeout(function(){
                  wx.navigateTo({
                    url: '../user/dingdan?currentTab=1&otype=deliver',
                  });
                },2500);
              },
              fail: function(res) {
                console.info(res);
                wx.showToast({
                  title: res.err_desc,
                  duration:3000
                })
              }
            })
          }else{
            wx.showToast({
              title: res.data,
              duration: 2000
            });
          }
        },
        fail: function() {
          // fail
          wx.showToast({
            title: '网络异常！err:wxpay',
            duration: 2000
          });
        }
      })
  },
});