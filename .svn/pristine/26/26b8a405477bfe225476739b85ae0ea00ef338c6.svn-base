package com.movieflix.activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.movieflix.MyApplication;
import com.movieflix.R;
import com.movieflix.adapters.ActorDetailsAdapter;
import com.movieflix.datamodel.ActorModel;
import com.movieflix.datamodel.ActorsListModelClass;
import com.movieflix.datamodel.MovieModel;
import com.movieflix.fragments.ActorDetailsCreditsFragment;
import com.movieflix.fragments.ActorDetailsInfoFragment;
import com.movieflix.trasnferdata.MoviesParsing;
import com.movieflix.trasnferdata.ParsingActorInfoDetails;
import com.movieflix.utils.UrlUtils;

import java.util.ArrayList;

import static com.movieflix.interfaces.ConstUtils.actorCredits;
import static com.movieflix.interfaces.ConstUtils.actorInfo;
import static com.movieflix.interfaces.ConstUtils.api_key;

public class ActorDetailsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    ActorDetailsInfoFragment actorDetailsInfoFragment;
    ActorDetailsCreditsFragment actorDetailsCreditsFragment;
    int actorID;
    String actorName, actorsFirstBackDropPath;
    private AppBarLayout mAppBarLayout_ad;
    private TabLayout mTabLayout_ad;
    private ViewPager mViewPager_ad;
    private ArrayList<Fragment> mActorDetailsFragmentList;
    private ActorDetailsAdapter actorDetailsAdapter;
    private Toolbar toolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private ImageView ivProfilePic;
    private ImageView ivBackgroundImage;
    private String actorInfoUrl, actorMovieCreditsUrl;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);
//        setupWindowAnimations();

        init();
//        setFragments();
        setUpActorDetails();

    }

    //
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
//        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
//        getWindow().setExitTransition(slide);
    }

    private void init() {
        progressBar = findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAppBarLayout_ad = findViewById(R.id.app_bar);
        mCollapsingToolbar = findViewById(R.id.toolbar_layout);
        ivProfilePic = findViewById(R.id.actor_Image);
        ivBackgroundImage = findViewById(R.id.iv_back_drop);

        mViewPager_ad = findViewById(R.id.actorDetailsActivityViewPager);
        mTabLayout_ad = findViewById(R.id.actorDetailsTabLayout);
        mViewPager_ad.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout_ad));
        mTabLayout_ad.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager_ad));
        ivBackgroundImage.setOnClickListener(this);
        ivProfilePic.setOnClickListener(this);

    }

    private void setUpActorDetails() {
        Intent actorDetails = getIntent();
        Bundle actorBundle = actorDetails.getExtras();
        if (actorBundle != null && actorBundle.containsKey("actorData")) {
            ActorsListModelClass actorsListModelClass = (ActorsListModelClass) actorBundle.getSerializable("actorData");
            if (actorsListModelClass != null) {
                actorName = actorsListModelClass.getActorName();
                setCollapsingToolbarTitle(actorName);
                String imgPath = UrlUtils.IMAGE_BASE_URL_185 + actorsListModelClass.getProfilePic();
                setAppBarLayoutColor(imgPath);
                Glide.with(this).load(imgPath).apply(new RequestOptions().onlyRetrieveFromCache(true)).
                        apply(RequestOptions.bitmapTransform(new CircleCrop())).//apply(RequestOptions.errorOf(R.drawable.error_image_pic)).
                        apply(RequestOptions.placeholderOf(R.drawable.error_image_pic)).
                        into(ivProfilePic);

//                Glide.with(this).load(UrlUtils.IMAGE_BASE_URL_320 + actorsListModelClass.getProfilePic())
//                        .apply(RequestOptions.bitmapTransform(new CenterCrop())).apply(RequestOptions.placeholderOf(R.drawable.loading_placehoder_hor))
//                        .apply(RequestOptions.errorOf(R.drawable.error_image_1)).into(ivBackgroundImage);
                actorID = actorsListModelClass.getID();

                actorInfoUrl = actorInfo + actorID + "?" + api_key;
                actorMovieCreditsUrl = actorInfo + actorID + "/" + actorCredits + api_key;
//                setFragmentState(actorInfoUrl);
                setUpViewPager(actorID, actorsListModelClass);

            }
        }
    }

//    private void setFragmentState(String url) {
//        if (currentFragment instanceof HandlingActorInfoResults) {
//            ((HandlingActorInfoResults) currentFragment).handlingInfoResults(url);
//        }
//    }

    private void setCollapsingToolbarTitle(String title) {
        mCollapsingToolbar.setTitle(title);
        mCollapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        mCollapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        mCollapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
    }

    private void setFragments() {
        if (actorDetailsCreditsFragment != null && actorDetailsInfoFragment != null) {
            Glide.with(this).load(UrlUtils.IMAGE_BASE_URL_500 + actorsFirstBackDropPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.error_image_backdrop)).into(ivBackgroundImage);
//                    .apply(RequestOptions.errorOf(R.drawable.noimage_horiz)).into(ivBackgroundImage);
            mActorDetailsFragmentList = new ArrayList<>();
            mActorDetailsFragmentList.add(actorDetailsInfoFragment);
            mActorDetailsFragmentList.add(actorDetailsCreditsFragment);
            actorDetailsAdapter = new ActorDetailsAdapter(getSupportFragmentManager(), mActorDetailsFragmentList);
            progressBar.setVisibility(View.GONE);
            mViewPager_ad.setAdapter(actorDetailsAdapter);
            mTabLayout_ad.setupWithViewPager(mViewPager_ad);

            setDetailsActivityTabTitle();
        }
    }

    private void setDetailsActivityTabTitle() {
        mTabLayout_ad.getTabAt(0).setText("Info");
        mTabLayout_ad.getTabAt(1).setText("Movies");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
//                currentFragment = actorInfoFragment;
//                String info = actorInfoUrl;
//                setFragmentState(info);
                break;
            case 1:
//                currentFragment = actorCreditsFragment;
//                String credits = actorMovieCreditsUrl;
//                setFragmentState(credits);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//        }
//        return false;
//    }

    private void setUpViewPager(int movieID, final ActorsListModelClass actorModel) {
//        ArrayList<MovieModel> movieModels = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, actorInfoUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ActorModel actorModel = new ParsingActorInfoDetails().parseActorModel(response);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("actorInfo", actorModel);
                actorDetailsInfoFragment = new ActorDetailsInfoFragment();
                actorDetailsInfoFragment.setArguments(bundle1);
                setFragments();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CoordinatorLayout coordinatorLayout = findViewById(R.id.detailRoot);
                Snackbar.make(coordinatorLayout, "Error Occurred", Snackbar.LENGTH_LONG);

            }
        });
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, actorMovieCreditsUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ArrayList<MovieModel> movieModels2 = new MoviesParsing().movieModelsParse(response);
                if (movieModels2 != null) {
                    try {
                        actorsFirstBackDropPath = movieModels2.get(0).getBackdropPath();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("Error", e.getMessage());
                    }
                }
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("actorCredits", movieModels2);
                actorDetailsCreditsFragment = new ActorDetailsCreditsFragment();
                actorDetailsCreditsFragment.setArguments(bundle1);
                setFragments();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CoordinatorLayout coordinatorLayout = findViewById(R.id.detailRoot);
                Snackbar.make(coordinatorLayout, "Error Occurred", Snackbar.LENGTH_LONG);

            }
        });


        MyApplication.getInstance().addToRequestQueue(stringRequest);
        MyApplication.getInstance().addToRequestQueue(stringRequest2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_detailsl, menu);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_home:
                gotoHome();
                break;
            case R.id.action_share:
                shareUrl();
                break;
            case R.id.action_open_tmdb:
                openWithBrowser();
                break;
            default:
                break;

        }
        return true;
//        return super.onOptionsItemSelected(item);
    }

    private void gotoHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    private void shareUrl() {
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intentShare.setType("text/*");
        intentShare.putExtra(Intent.EXTRA_TEXT, UrlUtils.TMDB_URL_ACTOR + actorID);
        startActivity(Intent.createChooser(intentShare, "Share '" + actorName + "' via"));
    }

    private void openWithBrowser() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("text/html");
        i.setData(Uri.parse(UrlUtils.TMDB_URL_ACTOR + actorID));
        startActivity(Intent.createChooser(i, "Open With"));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back_drop) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ivBackgroundImage, "image");
            Intent intent = new Intent(this, FullScreenImageActivity.class);
            intent.putExtra("title", actorName);
            intent.putExtra("image", UrlUtils.IMAGE_BASE_URL_500 + actorsFirstBackDropPath);
            startActivity(intent, optionsCompat.toBundle());
//            startActivity(intent);
        }
        if (view.getId() == R.id.actor_Image) {

        }
    }

    private void setAppBarLayoutColor(String imagePath) {
        RequestOptions requestOptions = new RequestOptions().onlyRetrieveFromCache(true);
        Glide.with(this).asBitmap().apply(requestOptions).load(imagePath).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                if (resource != null) {
                    Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(@NonNull Palette palette) {
                            final Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                            if (vibrantSwatch == null) {
                                return;
                            }
                            try {
                                int defaultValue = 0x000000;
                                final int vibrant = palette.getVibrantColor(defaultValue);
                                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), R.color.colorPrimary, vibrant);
                                colorAnimation.setDuration(250); // milliseconds
                                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                                    @Override
                                    public void onAnimationUpdate(ValueAnimator animator) {
//                                        textView.setBackgroundColor((int) animator.getAnimatedValue());
                                        mAppBarLayout_ad.setBackgroundColor((int) animator.getAnimatedValue());
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            getWindow().setStatusBarColor((int) animator.getAnimatedValue());
                                        }
                                        mCollapsingToolbar.setContentScrimColor((int) animator.getAnimatedValue());

//                                        title.setTextColor(vibrantSwatch.getBodyTextColor());
//                                        genres.setTextColor(vibrantSwatch.getBodyTextColor());
                                    }

                                });
                                colorAnimation.start();

                            } catch (Exception e) {
//                                title.setTextColor(getResources().getColor(R.color.colorPrimary));
//                                genres.setTextColor(getResources().getColor(R.color.colorPrimary));
                            }
                        }
                    });

                }

            }
        });

//        Volley.newRequestQueue(this).add(new ImageRequest(imagePath, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap bitmap) {
//                if (bitmap != null) {
//                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                        @Override
//                        public void onGenerated(@NonNull Palette palette) {
//                            int defaultValue = 0x000000;
//                            int vibrant = palette.getVibrantColor(defaultValue);
//                            int vibrantLight = palette.getLightVibrantColor(defaultValue);
//                            int vibrantDark = palette.getDarkVibrantColor(defaultValue);
//                            int muted = palette.getMutedColor(defaultValue);
//                            int mutedLight = palette.getLightMutedColor(defaultValue);
//                            int mutedDark = palette.getDarkMutedColor(defaultValue);
//                            int dominantColor = palette.getDominantColor(defaultValue);
//
//                            mAppBarLayout_ad.setBackgroundColor(mutedDark);
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                getWindow().setStatusBarColor(mutedDark);
//                            }
//                            mCollapsingToolbar.setContentScrimColor(mutedDark);
//                        }
//                    });
//
//                }
//            }
//        }, 200, 200, null, null));
    }
}

