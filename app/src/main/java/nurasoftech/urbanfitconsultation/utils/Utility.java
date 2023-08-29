package nurasoftech.urbanfitconsultation.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nurasoftech.urbanfitconsultation.Models.ErrorToastView;
import nurasoftech.urbanfitconsultation.Models.SuccessToastView;
import nurasoftech.urbanfitconsultation.R;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Utility {

    static SuccessToastView successToastView;
    static ErrorToastView errorToastView;
    public static String response;
    public static Dialog dialog;

    public static void showNormaredltoast(String msg, AppCompatActivity context) {
        Toast toast = new Toast(context);
        @SuppressLint("InflateParams") View layout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, null, false);
        TextView text = layout.findViewById(R.id.toastMessage);
        text.setText(msg);
        errorToastView = layout.findViewById(R.id.errorView);
        errorToastView.startAnim();
        text.setBackgroundResource(R.drawable.error_toast);
        text.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        // Home.mp1.start();
    }


    public static void showToastgreen(int datasavedsuccessfully, AppCompatActivity context) {
        Toast toast = new Toast(context);
        @SuppressLint("InflateParams") View layout = LayoutInflater.from(context).inflate(R.layout.success_toast_layout, null, false);
        TextView text = layout.findViewById(R.id.toastMessage);
        text.setText(datasavedsuccessfully);
        successToastView = layout.findViewById(R.id.successView);
        successToastView.startAnim();
        text.setBackgroundResource(R.drawable.success_toast);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        // Home.mp.start();
    }



    public static void showToastred(int datasavedsuccessfully, AppCompatActivity context) {
        Toast toast = new Toast(context);
        @SuppressLint("InflateParams") View layout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, null, false);
        TextView text = layout.findViewById(R.id.toastMessage);
        text.setText(datasavedsuccessfully);
        errorToastView = layout.findViewById(R.id.errorView);
        errorToastView.startAnim();
        text.setBackgroundResource(R.drawable.error_toast);
        text.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        // Home.mp1.start();
    }

    public static void getcurrectdata(String msg) {
        response = msg
                .replace(",", "")  //remove the commas
                .replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace(":", "")
                .replace("Message", "")
                .replace("Description", "")
                .replace("null", "")
                .replace("\"", "")
                .replace(".", "\n\n")
                .trim();
    }

    public static String printHashKey(Context pContext)
    {
        String keyhashstr = "";
        try
        {
            @SuppressLint("PackageManagerGetSignatures") PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                keyhashstr = new String(Base64.encode(md.digest(), 0));
                Log.i("TAG", "printHashKey() Hash Key: " + keyhashstr);
            }
        }  catch (Exception e) {
            Log.e("TAG", "printHashKey()", e);
        }

        return keyhashstr;
    }

    public static String convertResponseToNewDate1(String blogDate) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.US);
        String displayformat = "yyyy-MM-dd";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat destFormat = new SimpleDateFormat(displayformat, Locale.US);

        try {
            Date myDate = myFormat.parse(blogDate);
            assert myDate != null;
            return destFormat.format(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return blogDate;
    }

    public static String convertResponseToNewDate6(String blogDate) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        String displayformat = "dd-MMM-yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat destFormat = new SimpleDateFormat(displayformat, Locale.US);

        try {
            Date myDate = myFormat.parse(blogDate);
            assert myDate != null;
            return destFormat.format(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return blogDate;
    }

    public static String getcurrenttime13() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss", Locale.US);
        return sdf.format(new Date());
    }

    public static String getsystemdate()
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return sdf.format(new Date());
    }

    public static String getcurrenttime() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
        return sdf.format(new Date());
    }

    public static String getnormaldate() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        return sdf.format(new Date());
    }

    public static boolean checkConnection(Context context) {
        //boolean value = true;
        //            AlertDialog.Builder builder1 = new AlertDialog.Builder(context)
        //                    .setMessage(R.string.NoInternetMessage)
        //                    .setCancelable(false)
        //                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        //                        @Override
        //                        public void onClick(DialogInterface dialog, int which) {
        //                            dialog.dismiss();
        //                        }
        //                    });
        //            builder1.show();
        return ConnectivityReceiver.isConnected(context);
    }

    public static void progress(final Activity activity, final int flag, final String msg) {
        activity.runOnUiThread(() -> {
            Log.d("AMS", msg);
            switch (flag) {
                case 0:
                    dialog = new Dialog(activity);
                    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    dialog.setTitle(activity.getString(R.string.app_name));
                    dialog.setContentView(R.layout.dialog);
                    ImageView img = dialog.findViewById(R.id.imageView11);
                    img.setBackgroundResource(R.drawable.progress_anim);
                    AnimationDrawable frameAnamitaion = (AnimationDrawable) img.getBackground();
                    dialog.setTitle(activity.getString(R.string.process));
                    dialog.setCancelable(false);
                    if (!dialog.isShowing()) {
                        dialog.show();
                        frameAnamitaion.start();
                    }
                    break;
                case 1:
                    while (true) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        } else {
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        });
    }

}
