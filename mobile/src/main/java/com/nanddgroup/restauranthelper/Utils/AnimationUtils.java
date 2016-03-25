package com.nanddgroup.restauranthelper.Utils;

import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by Nikita on 25.03.2016.
 */
public class AnimationUtils {
    private TransitionDrawable transition;
    private int flag;
    private ImageView iv;

    public AnimationUtils(ImageView iv) {
        this.iv = iv;
    }

    public void init(){
        transition = (TransitionDrawable) iv.getBackground();
        flag = 1;
        handlechange();
    }


    private void change() {
        if (flag == 0) {
            transition.reverseTransition(500);
            flag = 1;
        } else {
            transition.startTransition(500);
            flag = 0;
        }
        handlechange();
    }

    private void handlechange() {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                change();
            }
        }, 11000);
    }

}
