// Generated by view binder compiler. Do not edit!
package io.artcreativity.monpremierprojet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.artcreativity.monpremierprojet.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AlertBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout alert;

  @NonNull
  public final Button delete;

  @NonNull
  public final Button modifier;

  private AlertBinding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout alert,
      @NonNull Button delete, @NonNull Button modifier) {
    this.rootView = rootView;
    this.alert = alert;
    this.delete = delete;
    this.modifier = modifier;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AlertBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AlertBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.alert, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AlertBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout alert = (RelativeLayout) rootView;

      id = R.id.delete;
      Button delete = ViewBindings.findChildViewById(rootView, id);
      if (delete == null) {
        break missingId;
      }

      id = R.id.modifier;
      Button modifier = ViewBindings.findChildViewById(rootView, id);
      if (modifier == null) {
        break missingId;
      }

      return new AlertBinding((RelativeLayout) rootView, alert, delete, modifier);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
