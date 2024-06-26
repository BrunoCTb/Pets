function deleteCard(id) {
    document.querySelector('.overlay').style.display = 'flex';
    document.querySelector('.delete-confirm-card').style.display = 'block';
    document.querySelector('#delete-link').setAttribute('href', '/admin/product/remove/' + id);
}

function closeCard() {
    document.querySelector('.overlay').style.display = 'none';
    document.querySelector('.delete-confirm-card').style.display = 'none';
}