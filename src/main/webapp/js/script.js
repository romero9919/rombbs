$(function(){
   $('.slicks').slick({
      slideToShow: 2,
      slideToScroll: 1, 
      infinite: true,
      speed: 500,
      autoplay:true,
      autoplaySpeed: 3000,      
   });
   
   //검색
   $('.dropdown-menu>a.dropdown-item').click(function(e){
      e.preventDefault();
      let $val = $(this).attr("href");
      let $txt = $(this).text();
      $('.dropdown-toggle').text($txt);
      $('.dropdown-toggle').val($val);
   });
});