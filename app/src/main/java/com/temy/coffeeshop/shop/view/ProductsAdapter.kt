package com.temy.coffeeshop.shop.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.temy.coffeeshop.R
import com.temy.coffeeshop.common.inflate
import com.temy.coffeeshop.common.toPriceFormat
import com.temy.coffeeshop.model.Product
import java.lang.RuntimeException

class ProductsAdapter(
    private val onItemClicked: (Product) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val MAX_CAFFEINE_LEVEL = 3
        private const val TYPE_ITEM = 0
        private const val TYPE_HEADER = 1
    }

    private var itemsList: List<ProductItem> = emptyList()

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.shop_header_text)

        fun bind(header: String) {
            textView.text = header
        }
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.shop_product_image)
        private val name: TextView = view.findViewById(R.id.shop_product_name)
        private val price: TextView = view.findViewById(R.id.shop_product_price)
        private val caffeineLevelText: TextView = view.findViewById(R.id.shop_caffeine_level_text)
        private val caffeineLevelContainer: LinearLayout =
            view.findViewById(R.id.shop_caffeine_level_container)

        fun bind(product: Product, onItemClicked: (Int) -> Unit) {
            itemView.setOnClickListener { onItemClicked(adapterPosition) }
            resetCaffeineViews()
            product.caffeineLevel?.let {
                setupCaffeineViews(product)
            }

            // TODO: Add image instead of mock color
            image.background = ColorDrawable(Color.CYAN)
            name.text = product.name
            price.text = product.price.toPriceFormat()
        }

        private fun resetCaffeineViews() {
            caffeineLevelContainer.removeAllViews()
            caffeineLevelText.visibility = View.GONE
        }

        private fun setupCaffeineViews(product: Product) {
            for (i in 1..MAX_CAFFEINE_LEVEL) {
                val cupDrawable = if (product.caffeineLevel!!.ordinal < i) {
                    ResourcesCompat.getDrawable(
                        caffeineLevelContainer.resources,
                        R.drawable.ic_coffee_cup_empty,
                        null
                    )
                } else {
                    ResourcesCompat.getDrawable(
                        caffeineLevelContainer.resources,
                        R.drawable.ic_coffee_cup_full,
                        null
                    )
                }
                val cupImageView = ImageView(caffeineLevelContainer.context)
                cupImageView.setImageDrawable(cupDrawable)
                caffeineLevelContainer.addView(cupImageView)
            }
            caffeineLevelText.visibility = View.VISIBLE
        }
    }

    fun applyProductList(list: List<Product>) {
        itemsList = list
            .groupBy { it.type }
            .flatMap { (type, products) ->
                listOf<ProductItem>(ProductItem.Header(type.name)) + products.map {
                    ProductItem.Item(
                        it
                    )
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TYPE_ITEM -> ProductViewHolder(parent.inflate(R.layout.shop_product_item))
        TYPE_HEADER -> HeaderViewHolder(parent.inflate(R.layout.shop_product_header_item))
        else -> throw RuntimeException("Unknown type found! $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = itemsList[holder.adapterPosition]) {
            is ProductItem.Item -> {
                (holder as ProductViewHolder).bind(item.product) {
                    onItemClicked(item.product)
                }
            }
            is ProductItem.Header -> (holder as HeaderViewHolder).bind(item.header)
        }
    }

    override fun getItemViewType(position: Int) = when (itemsList[position]) {
        is ProductItem.Item -> TYPE_ITEM
        is ProductItem.Header -> TYPE_HEADER
    }

    override fun getItemCount() = itemsList.size

    sealed class ProductItem {
        data class Item(val product: Product) : ProductItem()
        data class Header(val header: String) : ProductItem()
    }
}