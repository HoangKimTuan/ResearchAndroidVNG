package com.example.cpu10225.decodeqrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    private final double BITMAP_SIZE_LIMITATION = 512.0;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_decode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    i.setType("image/*");
                    startActivityForResult(i, 1);
                } catch (Exception ex) {
                    Log.i(ex.getMessage(), "startPickImage");
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            decode(data);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void decode(Intent data) {
        if (data == null) {
            return;
        }
        final Uri uri = data.getData();
        if (uri == null) {
            return;
        }
        InputStream is = null;
        try {
            is = this.getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            Bitmap scaledBitmap = getScaledBitmap(bitmap, BITMAP_SIZE_LIMITATION);
            String decoded = scanQRImage(scaledBitmap);
            result.setText(decoded);
        } catch (FileNotFoundException e) {
            return;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    return;
                }
            }
        }
    }

    public Bitmap getScaledBitmap(Bitmap bitmap, double limitSize) {
        Matrix matrix = new Matrix();
        int originalHeight = bitmap.getHeight();
        int originalWidth = bitmap.getWidth();
        int scaledSize;
        double scaleFactor;

        if (originalHeight > limitSize || originalWidth > limitSize) {
            if (originalHeight >= originalWidth) {
                scaleFactor = (limitSize / originalHeight);
                scaledSize = (int) (originalWidth * scaleFactor);
                matrix.setRectToRect(new RectF(0, 0, originalWidth, originalHeight),
                        new RectF(0, 0, scaledSize, (int) limitSize), Matrix.ScaleToFit.CENTER);
            } else {
                scaleFactor = (limitSize / originalWidth);
                scaledSize = (int) (originalHeight * scaleFactor);
                matrix.setRectToRect(new RectF(0, 0, originalWidth, originalHeight),
                        new RectF(0, 0, (int) limitSize, scaledSize), Matrix.ScaleToFit.CENTER);
            }

            bitmap = Bitmap.createBitmap(bitmap, 0, 0, originalWidth, originalHeight, matrix, true);
        }

        return bitmap;
    }

    private String scanQRImage(Bitmap bMap) {
        String contents = null;

        int[] intArray = new int[bMap.getWidth() * bMap.getHeight()];
        //copy pixel data from the Bitmap into the 'intArray' array
        bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());

        LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Hashtable<DecodeHintType, Object> hint = new Hashtable<>();
        hint.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

        Reader reader = new MultiFormatReader();
        try {
            Result result = reader.decode(bitmap, hint);
            contents = result.getText();
        } catch (Exception e) {
            return "Error";
        }
        return contents;
    }
}
