package br.com.etechoracio.atividade;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;


@SuppressLint("ValidFragment")
public class CustomDialog extends DialogFragment implements DialogInterface.OnClickListener {
	
	private ItemListener listener;
	private EditText edtName;
	private String item;
	
	@SuppressLint("ValidFragment")
	public CustomDialog(Context context) {
		if (!(context instanceof ItemListener)) {
			throw new IllegalArgumentException("A activity deve implementar CustomDialog.ItemListener");
		}
		this.listener = (ItemListener) context;
	}
	
	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle("Item");
		builder.setPositiveButton("OK", this);
		builder.setNegativeButton("Cancelar", this);

		View view = View.inflate(getActivity(), R.layout.dialog, null);
		builder.setView(view);
		
		this.edtName = view.findViewById(R.id.edt_name);
		
		if (item != null) {
			edtName.setText(item);
		}
		
		return builder.create();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (which == DialogInterface.BUTTON_POSITIVE) {
			String name = edtName.getText().toString();
			if (!TextUtils.isEmpty(name)) {
				listener.onItem(name);
			}
		}
	}
	
	public interface ItemListener {
		void onItem(String name);
	}
}
