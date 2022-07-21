package com.example.ecommerce.Model

class Cart {
    var transaction_id = 0
    var product_id = 0
    var qty = 0
    var amount = 0
    var status = 0

    constructor(transaction_id: Int, product_id: Int, qty: Int, amount: Int, status: Int) {
        this.transaction_id = transaction_id
        this.product_id = product_id
        this.qty = qty
        this.amount = amount
        this.status = status
    }

}
