package cc.shuozi.uidesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Implementation extends Fragment {//implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private String[][] data={{"Px"," "},{"Diet"," "},{"Physical Activity"," "}, {"Mental Activity"," "},{"Health Feed",""},{"Health Video",""}};
    private FirebaseAuth mAuth;
    private int i=0;
    private String[][] pxdata;
    private int a=0;
    private String[][] information;
    private String[][] padata;
    private String[][] madata;
    private ImageView avator_implmentation;
    private void getmanum(final callback oncallbackString)
    {
        a=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("mentalactivity")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                a++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }
                            oncallbackString.onCallbacknumber(a);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }

    private void checkma(final callback oncallbackString)
    {
        i=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("mentalactivity")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                madata[i][0]= String.valueOf(doc.get("Time id"));
                                madata[i][1]=doc.getString("Event");
                                madata[i][2]= String.valueOf(doc.get("Event start year"));
                                madata[i][3]= String.valueOf(doc.get("Event start month"));
                                madata[i][4]= String.valueOf(doc.get("Event start day"));
                                madata[i][5]= String.valueOf(doc.get("Event start hour"));
                                madata[i][6]= String.valueOf(doc.get("Event start minute"));
                                madata[i][7]= String.valueOf(doc.get("Event end year"));
                                madata[i][8]= String.valueOf(doc.get("Event end month"));
                                madata[i][9]= String.valueOf(doc.get("Event end day"));
                                madata[i][10]= String.valueOf(doc.get("Event end hour"));
                                madata[i][11]= String.valueOf(doc.get("Event end minute"));
                                i++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }

                            Arrays.sort(madata, new Comparator<String[]>() {
                                @Override
                                public int compare(String[] o1, String[] o2) {
                                    return Integer.parseInt(o2[0])-Integer.parseInt(o1[0]);
                                }
                            });


                            oncallbackString.onCallbackListstring(madata);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }
    private void getpanum(final callback oncallbackString)
    {
        a=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("physicalactivity")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                a++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }
                            oncallbackString.onCallbacknumber(a);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }

    private void checkpa(final callback oncallbackString)
    {
        i=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("physicalactivity")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                padata[i][0]= String.valueOf(doc.get("Time id"));
                                padata[i][1]=doc.getString("Event");
                                padata[i][2]= String.valueOf(doc.get("Event start year"));
                                padata[i][3]= String.valueOf(doc.get("Event start month"));
                                padata[i][4]= String.valueOf(doc.get("Event start day"));
                                padata[i][5]= String.valueOf(doc.get("Event start hour"));
                                padata[i][6]= String.valueOf(doc.get("Event start minute"));
                                padata[i][7]= String.valueOf(doc.get("Event end year"));
                                padata[i][8]= String.valueOf(doc.get("Event end month"));
                                padata[i][9]= String.valueOf(doc.get("Event end day"));
                                padata[i][10]= String.valueOf(doc.get("Event end hour"));
                                padata[i][11]= String.valueOf(doc.get("Event end minute"));
                                i++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }

                            Arrays.sort(padata, new Comparator<String[]>() {
                                @Override
                                public int compare(String[] o1, String[] o2) {
                                    return Integer.parseInt(o2[0])-Integer.parseInt(o1[0]);
                                }
                            });


                            oncallbackString.onCallbackListstring(padata);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }
    private void getdietnum(final callback oncallbackString)
    {
        a=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("diet")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                a++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }
                            oncallbackString.onCallbacknumber(a);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }
    private void getdietinfo(final callback oncallbackString)
    {
        i=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("diet")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                /*
                                 * information[][0]->time uid
                                 * information[][1]->year
                                 * information[][2]->month
                                 * information[][3]->day
                                 * */
                                information[i][0] = String.valueOf(doc.get("Time id"));
                                information[i][1] = String.valueOf(doc.get("Diet year"));
                                information[i][2] = String.valueOf(doc.get("Diet month"));
                                information[i][3] = String.valueOf(doc.get("Diet day"));
                                information[i][4] = doc.getString("Diet type");
                                i++;


                                Log.d("Status", "Success on get Document", task.getException());
                            }

                            Arrays.sort(information, new Comparator<String[]>() {
                                @Override
                                public int compare(String[] o1, String[] o2) {
                                    return Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]);
                                }
                            });
                            

                            oncallbackString.onCallbackListstring(information);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }

    private void getpxnum(final callback oncallbackString)
    {
        a=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("px")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                a++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }
                            oncallbackString.onCallbacknumber(a);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }
    private void checkalarm(final callback oncallbackString)
    {
        i=0;
        mAuth= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String value=user.getUid();
        db.collection("px")
                .whereEqualTo("uid", value)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot doc : task.getResult()) {
                                pxdata[i][0]= String.valueOf(doc.get("Time id"));
                                pxdata[i][1]=String.valueOf(doc.get("Event month"))+"/"+String.valueOf(doc.get("Event day"))+"/"+String.valueOf(doc.get("Event year"))
                                        +" "+String.valueOf(doc.get("Event hour"))+":"+String.valueOf(doc.get("Event minute"));
                                pxdata[i][2]=doc.getString("Event note");
                                pxdata[i][3]= String.valueOf(doc.get("Event year"));
                                pxdata[i][4]= String.valueOf(doc.get("Event month"));
                                pxdata[i][5]= String.valueOf(doc.get("Event day"));
                                pxdata[i][6]= String.valueOf(doc.get("Event hour"));
                                pxdata[i][7]= String.valueOf(doc.get("Event minute"));
                                i++;
                                Log.d("Status", "Success on get Document", task.getException());
                            }

                            oncallbackString.onCallbackListstring(pxdata);
                        } else {
                            Log.d("Status", "Error getting documents: ", task.getException());
                        }
                    }

                });
    }
/*
    private void initdrawer() {
        drawerLayout=findViewById(R.id.drawerlayout_implementation);
        toolbar=findViewById(R.id.toolbar_implementation);



        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }


            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };

        drawerToggle.syncState();

        drawerLayout.setDrawerListener(drawerToggle);


        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }

 */
    public Implementation()
    {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.activity_implementation, container, false);
        //setContentView(R.layout.activity_implementation);
        //NavigationView navigationView=rootview.findViewById(R.id.main_side);
        //initdrawer();
        //navigationView.setNavigationItemSelectedListener(this);

        //avator_implmentation= rootview.findViewById(R.id.avatar_implentation);
        /*
        if (avatorExists())
        {
            Uri imgUri=Uri.parse("file:///data/data/cc.shuozi.uidesign/avator.jpg");
            avator_implmentation.setImageURI(imgUri);
        }
*/
        final ListView list=rootview.findViewById(R.id.list_view_implementation);
        my_adapter_imp sc = new my_adapter_imp(getContext(), data);
        //list.setAdapter(sc);
        getpxnum(new callback() {
            @Override
            public void onCallback(String string) {

            }

            @Override
            public void onCallbacknumber(int i) {
                pxdata=new String[i][8];
                getdietnum(new callback() {
                    @Override
                    public void onCallback(String string) {

                    }

                    @Override
                    public void onCallbacknumber(int i) {
                        information=new String[i][5];
                        getmanum(new callback() {
                            @Override
                            public void onCallback(String string) {

                            }

                            @Override
                            public void onCallbacknumber(int i) {
                                madata=new String[i][12];
                                getpanum(new callback() {
                                    @Override
                                    public void onCallback(String string) {

                                    }

                                    @Override
                                    public void onCallbacknumber(int i) {
                                        padata=new String[i][12];
                                        checkalarm(new callback() {
                                            @Override
                                            public void onCallback(String string) {

                                            }

                                            @Override
                                            public void onCallbacknumber(int i) {

                                            }

                                            @Override
                                            public void onCallbackList(ArrayList<String> list) {

                                            }

                                            @Override
                                            public void onCallbackListstring(String[][] alarmdata) {

                                                pxdata=alarmdata.clone();
                                               if (pxdata.length==0)
                                               {
                                                   data[0][1] = "Related Activity: None";
                                               }else {
                                                   Arrays.sort(pxdata, new Comparator<String[]>() {
                                                       @Override
                                                       public int compare(String[] o1, String[] o2) {
                                                           return Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]);
                                                       }
                                                   });
                                                   data[0][1] = "Related Activity: " + pxdata[0][1];
                                               }

                                                getdietinfo(new callback() {
                                                    @Override
                                                    public void onCallback(String string) {

                                                    }

                                                    @Override
                                                    public void onCallbacknumber(int i) {

                                                    }

                                                    @Override
                                                    public void onCallbackList(ArrayList<String> list) {

                                                    }

                                                    @Override
                                                    public void onCallbackListstring(String[][] dietdata) {
                                                        information=dietdata.clone();
                                                        if (information.length==0)
                                                        {
                                                            data[1][1] = "Related Activity: None";
                                                        }else {
                                                            data[1][1] ="Related Activity: "+ information[0][2] + "/" + information[0][3] + "/" + information[0][1];
                                                        }
                                                        checkpa(new callback() {
                                                            @Override
                                                            public void onCallback(String string) {

                                                            }

                                                            @Override
                                                            public void onCallbacknumber(int i) {

                                                            }

                                                            @Override
                                                            public void onCallbackList(ArrayList<String> list) {

                                                            }

                                                            @Override
                                                            public void onCallbackListstring(final String[][] pa_data) {
                                                                padata=pa_data.clone();
                                                                if (padata.length==0)
                                                                {
                                                                    data[2][1] = "Related Activity: None";
                                                                }else {
                                                                if (Integer.parseInt(padata[0][6]) < 10){
                                                                    data[2][1]="Related Activity: "+padata[0][3]+"/"+padata[0][4]+"/"+padata[0][2]+"   "+padata[0][5]+":"+"0"+padata[0][6];
                                                                }else {
                                                                    data[2][1]="Related Activity: "+padata[0][3]+"/"+padata[0][4]+"/"+padata[0][2]+"   "+padata[0][5]+":"+padata[0][6];
                                                                }

                                                                }
                                                                checkma(new callback() {
                                                                    @Override
                                                                    public void onCallback(String string) {

                                                                    }

                                                                    @Override
                                                                    public void onCallbacknumber(int i) {

                                                                    }

                                                                    @Override
                                                                    public void onCallbackList(ArrayList<String> list) {

                                                                    }

                                                                    @Override
                                                                    public void onCallbackListstring(String[][] ma_data) {
                                                                        madata=ma_data.clone();
                                                                        if (madata.length==0)
                                                                        {
                                                                            data[3][1] = "Related Activity: None";
                                                                        }else
                                                                        {
                                                                        if (Integer.parseInt(madata[0][6]) < 10){
                                                                            data[3][1]="Related Activity: "+madata[0][3]+"/"+madata[0][4]+"/"+madata[0][2]+"   "+madata[0][5]+":"+"0"+madata[0][6];
                                                                        }else {
                                                                            data[3][1]="Related Activity: "+madata[0][3]+"/"+madata[0][4]+"/"+madata[0][2]+"   "+madata[0][5]+":"+madata[0][6];
                                                                        }


                                                                         }
                                                                        my_adapter_imp sc = new my_adapter_imp(getActivity(), data);
                                                                        list.setAdapter(sc);
                                                                    }

                                                                    @Override
                                                                    public void onCallbacklistdiet(String[][] data, food[][] foods) {

                                                                    }
                                                                });
                                                            }

                                                            @Override
                                                            public void onCallbacklistdiet(String[][] data, food[][] foods) {

                                                            }
                                                        });
                                                    }

                                                    @Override
                                                    public void onCallbacklistdiet(String[][] data, food[][] foods) {

                                                    }
                                                });
                                            }

                                            @Override
                                            public void onCallbacklistdiet(String[][] data, food[][] foods) {

                                            }
                                        });
                                    }

                                    @Override
                                    public void onCallbackList(ArrayList<String> list) {

                                    }

                                    @Override
                                    public void onCallbackListstring(String[][] data) {

                                    }

                                    @Override
                                    public void onCallbacklistdiet(String[][] data, food[][] foods) {

                                    }
                                });
                            }

                            @Override
                            public void onCallbackList(ArrayList<String> list) {

                            }

                            @Override
                            public void onCallbackListstring(String[][] data) {

                            }

                            @Override
                            public void onCallbacklistdiet(String[][] data, food[][] foods) {

                            }
                        });
                    }

                    @Override
                    public void onCallbackList(ArrayList<String> list) {

                    }

                    @Override
                    public void onCallbackListstring(String[][] data) {

                    }

                    @Override
                    public void onCallbacklistdiet(String[][] data, food[][] foods) {

                    }
                });
            }

            @Override
            public void onCallbackList(ArrayList<String> list) {

            }

            @Override
            public void onCallbackListstring(String[][] data) {

            }

            @Override
            public void onCallbacklistdiet(String[][] data, food[][] foods) {

            }
        });
        return rootview;
    }

/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.side_mainmenu:
                Intent main1=new Intent(Implementation.this, MainMenu.class);
                startActivity(main1);
                finish();
                return true;
            case R.id.side_setting:
                Intent main2=new Intent(Implementation.this, Setting.class);
                startActivity(main2);
                finish();
                return true;
            case R.id.side_implementation:
                Intent main3=new Intent(Implementation.this, Implementation.class);
                startActivity(main3);
                finish();
                return true;
            case R.id.side_decision:
                Intent main4=new Intent(Implementation.this, decision_making.class);
                startActivity(main4);
                finish();
                return true;
            case R.id.goal_menu:
                Intent main5=new Intent(Implementation.this, symptoms_goal.class);
                startActivity(main5);
                finish();
                return true;
            case R.id.information_menu:
                Intent main6=new Intent(Implementation.this, information.class);
                startActivity(main6);
                finish();
                return true;
        }
        return false;
    }

 */
    public boolean avatorExists()
    {
        try
        {
            File f=new File("file:///data/data/cc.shuozi.uidesign/avator.jpg");
            if(!f.exists())
            {
                return true;
            }

        }
        catch (Exception e)
        {
            return true;
        }

        return false;
    }

}