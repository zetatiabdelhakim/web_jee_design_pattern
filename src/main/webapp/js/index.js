setInterval(function(){
    let container = document.getElementsByClassName("bg")[0];
    var windowheight = window.innerHeight;
    let nav = document.getElementsByTagName("nav")[0];
    var navHeight = nav.offsetHeight;
    container.style.height = `${windowheight-navHeight}px`;
},100)
