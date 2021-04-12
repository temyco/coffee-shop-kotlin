package com.temy.coffeeshop.shop.details.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.temy.coffeeshop.R

class ProductDetailsFragment : Fragment() {

    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: replace mock args consumption with real case
        val textView: TextView = view.findViewById(R.id.product_details_text)
        textView.text = "Name: ${args.productData.name}\nDesc: ${args.productData.description}\nCaffeine: ${args.productData.caffeineLevel}\nType: ${args.productData.type.name}"
    }
}