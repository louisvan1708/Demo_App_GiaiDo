package com.example.demo_app_giaido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.billingclient.api.*
import com.google.common.collect.ImmutableList

class InappActivity : AppCompatActivity() {

    private lateinit var btn_Buy: TextView
    private val inapp_type_1 = "free_image_animal_15_day"
    private val inapp_type_2 = "free_image_animal_1_day"
    private val inapp_type_3 = "free_image_animal_30_day"
    private val inapp_type_4 = "free_image_animal_3_day"
    private val inapp_type_5 = "free_image_animal_7_day"

    private var lisProductDetails:MutableList<ProductDetails> = mutableListOf()
    private  lateinit var  billingClient: BillingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inapp)

        btn_Buy = findViewById(R.id.btn_Buy)

        val purchasesUpdatedListener =
            PurchasesUpdatedListener { billingResult, purchases ->
                // To be implemented in a later section.
            }
        billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode ==  BillingClient.BillingResponseCode.OK) {


                    val queryProductDetailsParams =
                        QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                ImmutableList.of(
                                    QueryProductDetailsParams.Product.newBuilder()
                                        .setProductId(inapp_type_3)
                                        .setProductType(BillingClient.ProductType.INAPP)
                                        .build()))
                            .build()

                    billingClient.queryProductDetailsAsync(queryProductDetailsParams) {
                            billingResult, productDetailsList ->
                        lisProductDetails=productDetailsList

                    }
                }
            }
            override fun onBillingServiceDisconnected() {

            }
        })

        btn_Buy.setOnClickListener {
            val productDetailsParamsList = listOf(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                    .setProductDetails(lisProductDetails[0])
                    .build()
            )

            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productDetailsParamsList)
                .build()

            // Launch the billing flow
            val billingResult = billingClient.launchBillingFlow(this, billingFlowParams)

        }
    }
}