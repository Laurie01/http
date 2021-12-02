// Generated by view binder compiler. Do not edit!
package io.artcreativity.monpremierprojet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.artcreativity.monpremierprojet.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RegularProductItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView price;

  @NonNull
  public final TextView quantityInStock;

  private RegularProductItemBinding(@NonNull ConstraintLayout rootView, @NonNull TextView name,
      @NonNull TextView price, @NonNull TextView quantityInStock) {
    this.rootView = rootView;
    this.name = name;
    this.price = price;
    this.quantityInStock = quantityInStock;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RegularProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RegularProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.regular_product_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RegularProductItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.price;
      TextView price = ViewBindings.findChildViewById(rootView, id);
      if (price == null) {
        break missingId;
      }

      id = R.id.quantity_in_stock;
      TextView quantityInStock = ViewBindings.findChildViewById(rootView, id);
      if (quantityInStock == null) {
        break missingId;
      }

      return new RegularProductItemBinding((ConstraintLayout) rootView, name, price,
          quantityInStock);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}