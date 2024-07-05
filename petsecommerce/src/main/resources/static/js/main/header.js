function profileOptionsCard() {
    var card = document.getElementsByClassName('profile-options-card')[0];
    card.style.display = "block";
}

document.addEventListener('click', function(event) {
    var card = document.getElementsByClassName('profile-options-card')[0];
    var isClickInside = card.contains(event.target);

    if (!isClickInside) {
        card.style.display = "none";
    }
});

// Prevent the click event from closing the card when clicking on the button
document.querySelector('#profile-options-open').addEventListener('click', function(event) {
    event.stopPropagation();
});