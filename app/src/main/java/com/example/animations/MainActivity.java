package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Animator.AnimatorListener {
    Button btnRotate,btnTranslate,btnFade,btnScale,btnSet,btnBattery;
    ImageView imgSteering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgSteering=findViewById(R.id.imgBattery);

        btnFade=findViewById(R.id.btnFade);
        btnRotate=findViewById(R.id.btnRotate);
        btnScale=findViewById(R.id.btnScale);
        btnTranslate=findViewById(R.id.btnTranslate);
        btnSet=findViewById(R.id.btnSet);
        btnBattery=findViewById(R.id.btnBattery);

        btnRotate.setOnClickListener(this);
        btnFade.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnSet.setOnClickListener(this);
        btnBattery.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFade:
                animationFade();
                break;
            case R.id.btnRotate:
                animationRotate();
                break;
            case R.id.btnScale:
                animationScale();
                break;
            case R.id.btnTranslate:
                animationTranslate();
                break;
            case R.id.btnSet:
                animationInterpolator();
                break;
            case R.id.btnBattery:
                Intent intent=new Intent(MainActivity.this,BatteryAnim.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }

    private void animationInterpolator() {
        Animator InterpolatorAnimator= AnimatorInflater.loadAnimator(this,R.animator.set);
        InterpolatorAnimator.setTarget(imgSteering);
        InterpolatorAnimator.addListener(this);
        InterpolatorAnimator.start();
    }

    private void animationTranslate() {
        Animator translateAnimator= AnimatorInflater.loadAnimator(this,R.animator.translation);
        translateAnimator.setTarget(imgSteering);
        translateAnimator.addListener(this);
        translateAnimator.start();
    }

    private void animationScale() {
        Animator scaleAnimator= AnimatorInflater.loadAnimator(this,R.animator.scaling);
        scaleAnimator.setTarget(imgSteering);
        scaleAnimator.addListener(this);
        scaleAnimator.start();
    }

    private void animationFade() {
        Animator fadeAnimator= AnimatorInflater.loadAnimator(this,R.animator.alpha);
        fadeAnimator.setTarget(imgSteering);
        fadeAnimator.addListener(this);
        fadeAnimator.start();
    }
    private void animationRotate() {
        Animator rotateAnimator= AnimatorInflater.loadAnimator(this,R.animator.rotation);
        rotateAnimator.setTarget(imgSteering);
        rotateAnimator.addListener(this);
        rotateAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animator) {
        Toast.makeText(this, "Animation Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        Toast.makeText(this, "Animation End", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        Toast.makeText(this, "Animation Cancelled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animator animator) {
        Toast.makeText(this, "Animation Repeated", Toast.LENGTH_SHORT).show();
    }
}
