$(document).ready(function () {
    $(".p-delete").click(function (event) {
        var confirmDelete = confirm("Tem certeza que deseja remover o produto?");

        event.preventDefault();
        
        if (confirmDelete) {
            var productId = $(this).data('product-id');
            $.ajax({
                url: "/carrinho/remover/" + productId,
                type: "POST",
                success: function (response) {
                    location.reload();
                },
                error: function (error) {
                    location.reload();
                }
            });
        }
    })
});