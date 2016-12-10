package com.example.towerhanoi;

import java.text.DecimalFormat;
import java.math.BigInteger;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/** Called when the activity is first created. */
public class MainActivity extends Activity 
{
   
    @Override
    protected void onCreate(Bundle savedInstanceState)     
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    BigInteger towerhanoiComputing(int n)
    {
    	BigInteger two = new BigInteger("2") ;
        BigInteger num = two.pow( n );
        BigInteger one = new BigInteger("1");
    	num = num.subtract( one );
    	
		return num;	
    }
    /*
    BigInteger towerhanoiComputing(int n)
    {
    	BigInteger num = (BigInteger) (Math.pow(2, n) -1) ;
    	
		return num;
		
    }
    
    */
    
    public void computeOnClick( View computeView )
    {
    	int nValue = 1; // ���w�]�@�ӭ� , �Ȧ�bug , �קK������Compute�X�{���D
    	BigInteger outValue; // �]�@���ܼƨӦs���G
    	
    	BigInteger modFive = new BigInteger("5");
    	BigInteger modZero = new BigInteger("0");
    	
    	/** �bjava���ŧi,��java code�Q�ΤU���ŧi���ܼƥh�s��xml�������s�B��r  */
    	EditText inputNumberLocal = (EditText) findViewById(R.id.inputNum);  /** �ϥΪ̿�JN����(���O��) */
    	TextView outputLocal = (TextView) findViewById(R.id.androidOutput);         /** ��ܵ��ת���          */
    	outputLocal.setTextColor(Color.BLACK);
    	
    	Button computeButtonLocal = (Button) findViewById(R.id.computeButton); /** �p�⪺���s */
    	Button exitButtonLocal = (Button) findViewById(R.id.exitButton);       /** ���}�����s */
    	/** �ŧi���� */
    	    	
    	nValue = Integer.parseInt( inputNumberLocal.getText().toString() );
    	outValue = towerhanoiComputing( nValue );
    	
    	
    	if ( outValue.mod(modFive).equals(modZero) )
    	{
    		outputLocal.setTextColor(Color.BLUE);
    	}

    		outputLocal.setText(""+outValue ); 
    		
    }
    
    public void exitOnClick ( View exitOnClick )
    {
    	finish();
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
