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
    	int nValue = 1; // 先預設一個值 , 怕有bug , 避免直接按Compute出現問題
    	BigInteger outValue; // 設一個變數來存結果
    	
    	BigInteger modFive = new BigInteger("5");
    	BigInteger modZero = new BigInteger("0");
    	
    	/** 在java中宣告,讓java code利用下面宣告的變數去存取xml中的按鈕、文字  */
    	EditText inputNumberLocal = (EditText) findViewById(R.id.inputNum);  /** 使用者輸入N的框(不是值) */
    	TextView outputLocal = (TextView) findViewById(R.id.androidOutput);         /** 顯示答案的值          */
    	outputLocal.setTextColor(Color.BLACK);
    	
    	Button computeButtonLocal = (Button) findViewById(R.id.computeButton); /** 計算的按鈕 */
    	Button exitButtonLocal = (Button) findViewById(R.id.exitButton);       /** 離開的按鈕 */
    	/** 宣告結束 */
    	    	
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
