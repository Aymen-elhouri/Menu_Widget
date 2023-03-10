package com.example.widget_menu;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class NewAppWidget extends AppWidgetProvider {

    public static final String MENU_ACTION = "com.example.widget.MENU_ACTION";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Perform update logic here
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equals(MENU_ACTION)) {
            // Handle menu button click here
            Toast.makeText(context, "Menu clicked", Toast.LENGTH_SHORT).show();
        }
    }

    public void openMenu(View view) {
        Intent menuIntent = new Intent(MENU_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(view.getContext(), 0, menuIntent, 0);

        RemoteViews remoteViews = new RemoteViews(view.getContext().getPackageName(), R.layout.new_app_widget);
        remoteViews.setOnClickPendingIntent(R.id.btn_menu, pendingIntent);

        AppWidgetManager.getInstance(view.getContext()).updateAppWidget(new ComponentName(view.getContext(), NewAppWidget.class), remoteViews);
    }

}
