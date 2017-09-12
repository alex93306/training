
function getTarget(e) {
    if(!e) {
        e=document.event;
    }

    var target= e.target || e.srcElement;
    return target;
}

function itemDone(e) {
    var target= getTarget(e);
    var parentEl = target.parentNode;
    var grandparentEl=parentEl.parentNode;

    grandparentEl.removeChild(parentEl);

    if(e.preventDefault) {
        e.preventDefault();
    } else {
        e.returnValue=false;
    }

}


var el=document.getElementById('shoppingList');

if(el.addEventListener) {
    el.addEventListener('click', function(e) {
        itemDone(e);
    }, false);
} else {
    el.attachEvent('onclick', function(e) {
        itemDone(e);
    });
}