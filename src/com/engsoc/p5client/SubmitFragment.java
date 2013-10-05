package com.engsoc.p5client;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubmitFragment extends Fragment 
{
	EditText eventKeyEntry;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.fragment_submit, container, false);
		Button submitAttendance = (Button) view.findViewById(R.id.fragment_submit_submitButton);
		Button populateFromQR = (Button) view.findViewById(R.id.fragment_submit_QRButton);
		eventKeyEntry = (EditText) view.findViewById(R.id.fragment_submit_eventKeyEntry);
		
		populateFromQR.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				submitEventAttendance();
			}
		});
		
		submitAttendance.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				populateEventKeyFromQR();
			}
		});
		
		return view;
	}
	
	public void submitEventAttendance()
	{
		String eventKey = eventKeyEntry.getText().toString();
		Toast.makeText(this.getActivity(), 0, 0).show();
	}
	
	public void populateEventKeyFromQR()
	{
		
	}

}
