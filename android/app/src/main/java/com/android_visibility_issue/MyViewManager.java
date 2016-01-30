package com.android_visibility_issue;

import android.app.Activity;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/**
 *
 */
public class MyViewManager extends ViewGroupManager<MyView> {

    public static final String REACT_CLASS = "MyView";
    private String TAG = MyViewManager.class.getSimpleName();
    private Activity mActivity;

    public MyViewManager(Activity activity) {
        mActivity = activity;
    }

    @Override public String getName() {
        return REACT_CLASS;
    }

    @Override protected MyView createViewInstance(ThemedReactContext reactContext) {

        MyView view = new MyView(reactContext);
        reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            @Override public void onHostResume() {
            }

            @Override public void onHostPause() {
            }

            @Override public void onHostDestroy() {
            }
        });
        return view;
    }

    @Override public void onDropViewInstance(ThemedReactContext reactContext, MyView view) {
        super.onDropViewInstance(reactContext, view);
    }

    @Override protected void addEventEmitters(ThemedReactContext reactContext, MyView view) {
        super.addEventEmitters(reactContext, view);
    }

    @Override protected void onAfterUpdateTransaction(MyView view) {
        super.onAfterUpdateTransaction(view);
    }

    @Override public void receiveCommand(MyView root, int commandId, ReadableArray args) {
        super.receiveCommand(root, commandId, args);
    }

    @Override public boolean needsCustomLayoutForChildren() {
        return true;
    }
}
