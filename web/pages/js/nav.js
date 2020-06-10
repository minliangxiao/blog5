$(window).scroll(function () {
  //小屏幕下的导航条折叠
  if ($(window).width() < 768) {
    //点击导航链接之后，把导航选项折叠起来
    $("#navbar a").click(function () {
      $("#navbar").collapse('hide');
    });
    //滚动屏幕时，把导航选项折叠起来
    $(window).scroll(function () {
      $("#navbar").collapse('hide');
    });
  }
});