setInterval(function(){
    let container = document.getElementsByClassName("container");
    var windowWidth = window.innerWidth;
    if (windowWidth < 576){
        container[0].style.width = "100%";
    }
    else if(windowWidth < 768){
        container[0].style.width = "90%";
    }
    else if(windowWidth < 992){
        container[0].style.width = "65%";
    }
    else if(windowWidth < 1200){
        container[0].style.width = "50%";
    }
    else{
        container[0].style.width = "30%";
    }
},100)