package com.example.www.androideverest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Window;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import static com.example.www.androideverest.App.CHANNEL_ID;

public class NotificationActivity extends AppCompatActivity {

    String statusbar_color = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

//        تغییر متن تیتر ActionBar
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_notification_broadcast_receiver);
    }


//    متد برای onClick نمایش یک نوتیفیکیشن پیشفرض
    public void show_default(View view) {

//        ایجاد Intent لازم برای PendingIntent لازم برای نوتیفیکیشن
        Intent notidicationIntent = new Intent(getApplicationContext(), NotificationActivity.class);
//        ایجاد PendingIntent لازم برای نوتیفیکیشن
//       چهار آرگومان
//            کانتکست اپلیکیشن
//            برای دویافت جواب از Intent
//            خود Intent مورد نظر
//            برای علامت گذاری PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                notidicationIntent,
                0);


//        ایجاد Intent لازم برای PendingIntent برای دکمه اول
        Intent intent_action1 = new Intent(NotificationActivity.this, NotificationReceiver.class);
//        رشته زیر یک سیگنال است که خودمان نوشتیم و در فایل مانیفست آنرا به receiver مشخصی متصل کردیم
        intent_action1.setAction("com.example.www.androideverest.NOTIFICATION_ACTION");
//        برای مشخص شدن دکمه فشرده شده در داخل Broadcast Receiver خودمان
        intent_action1.putExtra("action", "1");
        PendingIntent pending_action1 = PendingIntent.getBroadcast(
                getApplicationContext(),
                1,
                intent_action1,
                PendingIntent.FLAG_ONE_SHOT);
//        پرچم (علامت) FLAG_ONE_SHOT برای فقط یکبار اجرا شدن PendingIntent
//        پرچم (علامت) FLAG_CANCEL_CURRENT برای لغو کردن PendingIntent اگر در حال اجرا باشد و اجرا کردن PendingIntent جدید
//        پرچم (علامت) FLAG_UPDATE_CURRENT برای آپدیت کردن Action و Extra در PendingIntent اگر در حال اجرا باشد و اجرا کردن دوباره آن


//        ایجاد Intent لازم برای PendingIntent برای دکمه دوم
        Intent intent_action2 = new Intent(NotificationActivity.this, NotificationReceiver.class);
        intent_action2.setAction("com.example.www.androideverest.NOTIFICATION_ACTION");
        intent_action2.putExtra("action", "2");
        PendingIntent pending_action2 = PendingIntent.getBroadcast(
                getApplicationContext(),
                2,
                intent_action2,
                PendingIntent.FLAG_ONE_SHOT);


//        ایجاد و آماده کردن نوتیفیکیشن برای نمایش
        Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
//                مقدار دهی عنوان
                .setContentTitle("My Title")
//                مقدار دهی متن
                .setContentText("My Content Text")
//                مقدار دهی PendingIntent
                .setContentIntent(pendingIntent)
//                مشخص کردن آیکون
                .setSmallIcon(R.drawable.ic_notification)
//                برای بسته شدن هنگام کلیک شدن
                .setAutoCancel(true)
//                تبدیل نوتیفیکیشن به نوع Ongoing که اهمیت بالاتری نسبت به نوع معمولی دارد
                .setOngoing(true)
//                خاموش و روشن کردن نمایش زمان نوتیفیکیشن
                .setShowWhen(true)
//               ممقداردهی زمان نوتیفیکیش
                .setWhen(Calendar.getInstance().getTimeInMillis())
//                Calendar.getInstance().getTimeInMillis()
//                به معنی مقدار زمانی که از تاریخ مشخصی (یک ثابت در جاوا) گذشته است به میلی ثانیه
//                یعنی اگر اون رو منهای ده هزار کنید میشه ده دقیقه قبل
//                *** چند خط جلوتر برای تاریخ جعلی
//
//                اضافه کردن دکمه
//                سه آرگومان
//                    آیکون
//                    متن دکمه
//                    اتصال یک PendingIntent
                .addAction(R.drawable.ic_settings, "Action 1", pending_action1)
                .addAction(R.drawable.ic_settings_remote, "Action 2", pending_action2)
//                خط آخر فراموش نشود
                .build();
//        نوتیفیکیشن آماده نمایش شد


//        ایجاد یک تاریخ جعلی
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, 12);
//            cal.set(Calendar.MONTH, 12);
//            cal.set(Calendar.DAY_OF_MONTH, 12);
//            cal.set(Calendar.HOUR_OF_DAY, 12);
//            cal.set(Calendar.MINUTE, 12);
//            cal.set(Calendar.SECOND, 12);
//        تبدیل تاریخ جعلی به میلی ثانیه
//            cal.getTimeInMillis();


//        دسترسی به سرویس مربوط به نوتیفیکیشن و قرار دادن آن در یک شی
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//        بررسی اینکه آیا واقعا به سرویس مربوط به نوتیفیکیشن دسترسی پیدا کردیم یا خیر
        if (manager != null)
            manager.notify(0, notification); // اعلام نوتیفیکیشن
        else
            Toast.makeText(NotificationActivity.this, "NotificationManager is Null", Toast.LENGTH_SHORT).show();
    }


//    متد برای onClick نمایش یک نوتیفیکیشن سفارشی با Layout خودمان
    public void show_custom(View view) {

//        ایجاد Intent لازم برای PendingIntent لازم برای نوتیفیکیشن
        Intent notidicationIntent = new Intent(getApplicationContext(), NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                notidicationIntent,
                0);

//        تبدیل Layout به یک شی از نوع RemoteViews
        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.notification_expanded);
        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_collapsed);


//        تغییر دادن Layout درون RemoteViews
//        تغییر عکس یک ImageView درون این RemoteViews با اشاره به id همان ImageView و مشخص کردن عکس جدید
        expandedView.setImageViewResource(R.id.big_icon, R.drawable.ic_settings_phone);
//        تغییر متن یک TextView درون این RemoteViews با اشاره به id همان TextView و مشخص کردن متن جدید
        expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
        expandedView.setTextViewText(R.id.notification_message, "Hello Expanded World");

        collapsedView.setImageViewResource(R.id.big_icon, R.drawable.ic_settings_phone);
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));


//        ایجاد و آماده کردن نوتیفیکیشن برای نمایش
        Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                .setContentTitle("My Title")
                .setContentText("My Content Text")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_settings_phone)
                .setAutoCancel(true)
                .setOngoing(true)
//                این خط برای وصل کردن RemoteViews مربوط به نوتیفیکیشن در حالت گسترده شده
                .setCustomBigContentView(expandedView)
//                این خط برای وصل کردن RemoteViews مربوط به نوتیفیکیشن در حالت فشرده
                .setCustomContentView(collapsedView)
//               نوشتن خط بعدی برای استفاده از Layout خودمون توی نوتیفیکیشن اجباریه
                .setStyle(new androidx.core.app.NotificationCompat.DecoratedCustomViewStyle())
                .build();

//        دسترسی به سرویس مربوط به نوتیفیکیشن و قرار دادن آن در یک شی
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//        بررسی اینکه آیا واقعا به سرویس مربوط به نوتیفیکیشن دسترسی پیدا کردیم یا خیر
        if (manager != null)
            manager.notify(0, notification); // اعلام نوتیفیکیشن
        else
            Toast.makeText(NotificationActivity.this, "NotificationManager is Null", Toast.LENGTH_SHORT).show();
    }


//    متد برای onClick ارسال یک سیگنال به Broadcast Receiver
    public void send_broadcast_to_my_receiver(View view) {
//        ایجاد یک Intent با مقصد Broadcast Receiver
        Intent intent = new Intent(NotificationActivity.this, NotificationReceiver.class);
//        رشته زیر یک سیگنال است که خودمان نوشتیم و در فایل مانیفست آنرا به receiver مشخصی متصل کردیم
        intent.setAction("com.example.www.androideverest.RECEIVER_ACTION");
//        فعال کردن Broadcast Receiver با Intent
        sendBroadcast(intent);
    }


//    متد برای رنگی کردن StatusBar
    public void change_statusbar_color(View view) {

//        مقایسه API کاربر با API-21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

//            به دست آوردن شی Window از اکتیویتی فعلی
            Window window = getWindow();

//            ذخیره کردن رنگ فعلی در یک متغییر از نوع رشته
//            رنگ به همراه کانال alpha ذخیره می شود
//            #ffffffff
            statusbar_color = "#" + Integer.toHexString(window.getStatusBarColor());
//
//            متد window.getStatusBarColor رنگ فعلی را به صورت عدد صحیح استخراج می کند
//            متد Integer.toHexString عدد صحیح را به رشته ای در مبنای 16 تبدیل می کند

//            تنظیم رنگ StatusBar
            window.setStatusBarColor(Color.parseColor("#ffaa8822"));
//
//            برای استفاده از یک کد رنگ به صورت رشته
//            Color.parseColor("#ffff00")
//            برای به دست آوردن رنگ موجود در فایل colors.xml می توان خط زیر را استفاده کرد
//            ContextCompat.getColor(this, R.color.myColor)

        } else {
            Toast.makeText(this, "This feature need Android 5.0 (API-21) or higher version.", Toast.LENGTH_LONG).show();
        }

    }


//    متد برای برگرداندن رنگ قبلی به StatusBar
    public void change_statusbar_color_transparent(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();

//            اگر متغییر statusbar_color خالی نبود یعنی رنگ را تغییر دادیم
//            اگر خالی بود به معنی این است که هنوز اصلا رنگ را تغییر ندادیم
            if (!statusbar_color.isEmpty()) {
                window.setStatusBarColor(Color.parseColor(statusbar_color));
            } else {
                Toast.makeText(this, "You did not change StatusBar color, first change color.", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "This feature need Android 5.0 (API-21) or higher version.", Toast.LENGTH_LONG).show();
        }

    }

}
