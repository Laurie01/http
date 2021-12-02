// Generated by view binder compiler. Do not edit!
package io.artcreativity.monpremierprojet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.artcreativity.monpremierprojet.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class SimpleProductItemBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  private SimpleProductItemBinding(@NonNull TextView rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static SimpleProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SimpleProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.simple_product_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SimpleProductItemBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new SimpleProductItemBinding((TextView) rootView);
  }
}
