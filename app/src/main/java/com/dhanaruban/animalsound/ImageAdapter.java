package com.dhanaruban.animalsound;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.GridView;

import com.dhanaruban.animalsound.R;

// Extend the BaseAdapter class//

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Define an array of drawables that’ll be displayed in the GridView//
    public Integer[] gridviewImages = {
            R.drawable.african_grey_parrot, R.drawable.alligator,
            R.drawable.alpaca, R.drawable.anteater,
            R.drawable.antelope, R.drawable.ape,
            R.drawable.bat, R.drawable.bee,
            R.drawable.bowhead_whale, R.drawable.buffalo,
            R.drawable.cat, R.drawable.chicken,
            R.drawable.cow, R.drawable.dog,
            R.drawable.dove, R.drawable.duck,
            R.drawable.elephant, R.drawable.falcon,
            R.drawable.guinea_pig, R.drawable.horse,
            R.drawable.humpback_whale, R.drawable.leopard,
            R.drawable.lion,R.drawable.lizard,
            R.drawable.moose,R.drawable.owl,
            R.drawable.panda,R.drawable.penguin,
            R.drawable.pig,R.drawable.rabbit,
            R.drawable.raccoon,R.drawable.rhinoceros,
            R.drawable.rooster,R.drawable.sheep,
            R.drawable.tiger,R.drawable.turkey,
            R.drawable.zebra
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    // Get the number of images in the gridviewImages array//
    public int getCount() {
        return gridviewImages.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // The getView method is responsible for creating an ImageView for each image in our array.
// To provide a better user experience, I’m using the convertView method to specify that the
// Adapter should recycle views whenever possible, instead of creating a new view for every single
// item in our data set. Reusing views that are no longer visible to the user, improves the app’s
// performance, as the system doesn’t have to keep inflating views and doesn’t waste memory keeping
// a bunch of unnecessary views alive in the background
    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        // Check whether convertView is null
        if (convertView == null) {
            // If convert is null, then this means we cannot recycle an old view,
            // and need to create a new one
            imageView = new ImageView(mContext);

            // To make sure each image is displayed as you intended, you may need to assign some properties to
            // your ImageViews. I’m going to use setLayoutParams to specify how each image should be resized
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));

            // setScaleType defines how the image should be scaled and positioned. I’m using the CENTER_CROP
            // value as this maintains the image’s aspect ratio by scaling it in both directions, and then
            // centers the newly-scaled image.
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2,2,2,2);

        } else {
            // If the view passed to getView is not null, then recycle the view
            imageView = (ImageView) convertView;
        }

        // Use the position integer to select an image from the gridviewImages array, and set it to the
        // ImageView we just created
        imageView.setImageResource(gridviewImages[position]);
        return imageView;
    }
}