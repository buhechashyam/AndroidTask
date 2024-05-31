package com.example.ecommerceapp_webservice.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public  class Utils {

    List<ProductModel> mProduct = new ArrayList<ProductModel>();

    public List<ProductModel> getmProducts() {
        mProduct.add(new ProductModel("Jeans", "Lymio Jeans for Men", R.drawable.image_1, 749, "men jeans || men jeans pants || Denim Jeans || jeans for men\n" +
                "Disclaimer : Kindly Refer To The Size Chart (Also Mentioned In Images) For Fitting Measurements.1")
        );
        mProduct.add(new ProductModel("Jeans", "Ben Martin Men's Relaxed Fit Jeans", R.drawable.image_2, 499, "FASHION TREND DESIGN : This Ben Martin mens stylish stretchable jeans pant for men is versatile and can be paired with various tops. Like Shirt, Tshirt, Tees, Polo, Sweatshirts, Jackets, Waistcoat even Blazzers.\n"));
        mProduct.add(new ProductModel("Jeans", "Levi's Men's 512 Slim Tapered Fit Jeans", R.drawable.image_4, 1799," 'Live in Levi's' asserts with confidence and pride that Levi's clothes are indeed for everybody who's not just anybody." )
        );
        mProduct.add(new ProductModel("Jeans", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.image_1, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Shirt", "Lymio Jeans for Men", R.drawable.img1, 749, "men jeans || men jeans pants || Denim Jeans || jeans for men\n" +
                "Disclaimer : Kindly Refer To The Size Chart (Also Mentioned In Images) For Fitting Measurements.1")
        );
        mProduct.add(new ProductModel("Shirt", "Ben Martin Men's Relaxed Fit Jeans", R.drawable.img2, 499, "FASHION TREND DESIGN : This Ben Martin mens stylish stretchable jeans pant for men is versatile and can be paired with various tops. Like Shirt, Tshirt, Tees, Polo, Sweatshirts, Jackets, Waistcoat even Blazzers.\n"));
        mProduct.add(new ProductModel("Shirt", "Levi's Men's 512 Slim Tapered Fit Jeans", R.drawable.img3, 1799," 'Live in Levi's' asserts with confidence and pride that Levi's clothes are indeed for everybody who's not just anybody." )
        );
        mProduct.add(new ProductModel("Shirt", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.img4, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );


        mProduct.add(new ProductModel("Saari", "Mehrang Cotton Banarasi Silk Saree for Women With Unstitched Blouse Piece", R.drawable.image_5, 1499,"Saree is an elegant fabric that is truly captivating for saree lovers. This helps to explain the popularity of these modern-looking sarees." )
        );

        mProduct.add(new ProductModel("Saari", "ILIKA Cotton Color floral Pattern and Woven Design The saree comes with an unstitched blouse piece", R.drawable.image_6, 1299,"ILIKA Cotton Color floral Pattern and Woven Design The saree comes with an unstitched blouse piece" )
        );

        mProduct.add(new ProductModel("Saari", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.image_5, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Saari", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.image_6, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Dress", "Mehrang Cotton Banarasi Silk Saree for Women With Unstitched Blouse Piece", R.drawable.image_5, 1499,"Saree is an elegant fabric that is truly captivating for saree lovers. This helps to explain the popularity of these modern-looking sarees." )
        );

        mProduct.add(new ProductModel("Dress", "ILIKA Cotton Color floral Pattern and Woven Design The saree comes with an unstitched blouse piece", R.drawable.image_6, 1299,"ILIKA Cotton Color floral Pattern and Woven Design The saree comes with an unstitched blouse piece" )
        );

        mProduct.add(new ProductModel("Dress", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.image_5, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Dress", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.image_6, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );


        mProduct.add(new ProductModel("Kids", "Levi's  31 1 Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Kids", "Levi's 31 Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Kids", "Levi's 3 Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Kids", "Levi's 1 Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Sports", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Sports", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Sports", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Sports", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Rain Wear", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Rain Wear", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Rain Wear", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );

        mProduct.add(new ProductModel("Rain Wear", "Levi's Men's 512 Slim Tapered Fit Mid Rise Jeans", R.drawable.ic_jeans, 1279,"Everything you like about 512 Slim, but updated with a narrow fit through the thigh and tapered leg for the fashion-forward guy. It's perfect for the modern look right now" )
        );
        return mProduct;

    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
