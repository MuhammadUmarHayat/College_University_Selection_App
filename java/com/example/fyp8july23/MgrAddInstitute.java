package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MgrAddInstitute extends AppCompatActivity {
    EditText etInstituteNames1,etInstituteLink1,etInstCity1,etInsAddress1;
    EditText mgr1NameTv1;
    Spinner spInstMedium1,spInstLevel1;
    Button btnSave,btnBack;
    MyDBHelper dbMain;
    SQLiteDatabase db;
    ImageView photo;
    private static final int PICK_IMAGE_REQUEST=100;

    private Uri imageFilePath;
    private Bitmap imageStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_add_institute);
        etInstituteNames1 =findViewById(R.id.AdminetInstituteNamesMgr);
        etInstituteLink1 =findViewById(R.id.AdminetInstituteLinkMgr);
        etInstCity1 =findViewById(R.id.AdminetInstCityMgr);
        etInsAddress1 =findViewById(R.id.AdminetInsAddressMgr);
        spInstMedium1  =findViewById(R.id.AdminspInstMediumMgr);//spInstLevel

        spInstLevel1  =findViewById(R.id.AdminspInstLevelMgr);//
        btnSave =findViewById(R.id.AdminbtnInsSaveMgr);
        btnBack =findViewById(R.id.AdminbtnInsBacksMgr);
        mgr1NameTv1=findViewById(R.id.Adminmgr1NameTv2Mgr);
        photo=findViewById(R.id.photo1Mgr);
        dbMain=new MyDBHelper(this);


        Intent intent = getIntent();
        String name = intent.getStringExtra("userid");

        mgr1NameTv1.setText(name);
        selectPhoto();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(MgrAddInstitute.this, Manager.class);
                startActivity(page);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {


                String status="ok";
                String link=etInstituteLink1.getText().toString();
                String name =  etInstituteNames1.getText().toString();
                String  address= etInsAddress1.getText().toString();
                String medium =  spInstMedium1.getSelectedItem().toString();
                String  city= etInstCity1.getText().toString();
                String manager =  mgr1NameTv1.getText().toString();
                String level=spInstLevel1.getSelectedItem().toString();





                try {
                    // public Institute(int id, String name, String medium, String address, String managerid,
                    // String link, String status, Bitmap img, String manager,level)
                    ContentValues cv = new ContentValues();
                    cv.put("name", name);
                    cv.put("medium",medium );

                    cv.put("address", address);
                    cv.put("managerid",city );

                    cv.put("link", link);
                    cv.put("status",status );
                    cv.put("photo", ImageViewToByte(photo));

                    cv.put("manager", manager);
                    cv.put("level",level );


                    db = dbMain.getWritableDatabase();
                    long inserted = db.insert("institutes", null, cv);
                    if (inserted > 0) {
                        Toast.makeText(MgrAddInstitute.this, "Record is saved", Toast.LENGTH_SHORT).show();
                        //  photo.setImageResource(R.mipmap.ic_launcher);
                        //   name.setText("");
                    }
                }
                catch (Exception exp)
                {
                    Toast.makeText(MgrAddInstitute.this, "error"+exp.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    etInstituteNames1.setText(exp.getMessage().toString());
                }



            }
        });
    }//end of create

    private void selectPhoto()
    {
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chooseImage(view);
            }
        });
    }

    private byte[] ImageViewToByte(ImageView photo)
    {
        Bitmap bitmap=((BitmapDrawable)photo.getDrawable()).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        byte[] bytes=stream.toByteArray();
        return bytes;
    }

    public void chooseImage(View objectView)
    {
        try
        {
            Intent objectIntent=new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);

        }
        catch(Exception exp){

            Toast.makeText(this,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null &&data.getData()!=null)
            {
                imageFilePath=data.getData();
                imageStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
                photo.setImageBitmap(imageStore);

            }


        }
        catch(Exception exp){

            Toast.makeText(this,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }





}