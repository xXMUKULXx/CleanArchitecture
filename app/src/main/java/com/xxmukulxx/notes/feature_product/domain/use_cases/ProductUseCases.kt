package com.xxmukulxx.notes.feature_product.domain.use_cases

data class ProductUseCases(
    val getProducts: GetProducts,
    val insertProduct: InsertProduct,
    val deleteProduct: DeleteProduct,
    val updateProduct: UpdateProduct,
)