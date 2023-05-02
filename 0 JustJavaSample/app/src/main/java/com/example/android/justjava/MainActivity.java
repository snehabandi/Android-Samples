package com.example.android.justjava;
/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.order;
import static android.R.attr.y;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    boolean hasWhippedCream;
    boolean hasChocolate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //changes made to view is passed here
        //parsing of code starts from the parameter passed
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       // int numberOfCoffees=2;
        //display(quantity);
       // int price = calculatePrice();
        //String priceMessage = "Total : $" + (price) ;
       // displayPrice(price);
        //priceMessage = priceMessage  + "\nThank you !";
        //displayPrice(quantity * 5);

        //---------- >> GPS Intent
        /*
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:37.42,-122.07"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        */

        Intent intent = new Intent(Intent.ACTION_SENDTO);       //Initializing the object
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);     //To add extra data in intent : this one for address
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for "+name);     //To add subject
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {  //Just a check if we have an app to handle this
            startActivity(intent);
        }

        displayMessage(createOrderSummary());

    }
public int calculatePrice()
{
    int pricePerCup = 5;
    if(hasWhippedCream)
        pricePerCup += 1;
    if(hasChocolate)
        pricePerCup += 2;
    return (quantity*pricePerCup);

}
public String createOrderSummary()
{
    CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_check_box);
    hasWhippedCream = whippedCreamCheckBox.isChecked();

    CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_check_box);
    hasChocolate = chocolateCheckBox.isChecked();

    EditText editTextobject = (EditText)findViewById(R.id.name_edit_text);
    String Name = editTextobject.getText().toString();

    //Log.v("MainActivity","\nName : " + Name);

    String orderSummaryMessage = "\nCustomer : "+Name;
    //orderSummaryMessage = orderSummaryMessage + "\nQuantity : " + quantity;
    orderSummaryMessage += "\nAdd Whipped Cream ? " + hasWhippedCream;
    orderSummaryMessage += "\nAdd Chocolate ? " + hasChocolate;
    orderSummaryMessage += "\nQuantity : " + quantity;
    orderSummaryMessage = orderSummaryMessage + "\nTotal : $" + calculatePrice();
    orderSummaryMessage = orderSummaryMessage + "\nThank You !";
    return orderSummaryMessage;
}
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    public void increment(View view)
    {
        if(quantity==100) {
            //Show an error message as toast
            Toast.makeText(this,"You cannot have more than 100coffees", Toast.LENGTH_SHORT).show();
            //Exit this method early because there is nothing left to do
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }
    public void decrement(View view)
    {
        if(quantity==1) {
            //Show an error message as toast
            Toast.makeText(this,"You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            //Exit this method early because there is nothing left to do
            return;

        }

        quantity = quantity - 1;
        display(quantity);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.price_text_view);
        orderSummaryTextView.setText(message);

    }
}