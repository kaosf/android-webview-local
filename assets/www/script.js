function addItem() {
  var ul = document.getElementById('list');
  var newLi = document.createElement('li');
  newLi.innerHTML = "new item";
  ul.appendChild(newLi);
}
