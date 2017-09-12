var el=document.getElementsByTagName('li');
var newEl = document.createElement('li');
newEl.appendChild(document.createTextNode('Haha'));
el[0].parentNode.appendChild(newEl);
el[3].innerHTML='</ul>';
var text=encodeURI('http://www.tut.by?q=%dd');
document.write(text);
text='&ltul&gt<li>new list</li>';
document.write(text);

var output=document.getElementById('output');
output.innerHTML=text;

