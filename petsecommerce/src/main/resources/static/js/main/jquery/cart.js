$(document).ready(function () {
    // Remover produto
    $(".p-delete").click(function (event) {
        var confirmDelete = confirm("Tem certeza que deseja remover o produto?");
        event.preventDefault();
        if (confirmDelete) {
            var productId = $(this).closest(".product-actions").data('product-id');
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
    });

    $(".plus-quantity, .sub-quantity").click(function (event) {
        var input = $(this).siblings(".p-quantity-value");
        var productId = $(this).closest(".product-actions").data('product-id');
        var operation = this.innerHTML == "+" ? "plus" : "sub";

        $.ajax({
            url: "/carrinho/quantidade/" + operation + "=" + productId,
            type: "POST",
            success: function (response) {
                console.log(productId);
            },
            error: function (error) {
                alert("erro");
            }
        });

        if (operation == "sub" && input.val() > 0) {
            input.val(parseInt(input.val()) - 1);
        }else if(operation == "plus"){
            input.val(parseInt(input.val()) + 1);
        }
    });
});