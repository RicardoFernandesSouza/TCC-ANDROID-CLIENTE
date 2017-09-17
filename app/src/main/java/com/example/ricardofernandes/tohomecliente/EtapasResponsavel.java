package com.example.ricardofernandes.tohomecliente;

/**
 * Created by RicardoFernandes on 07/06/2017.
 */


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static android.widget.Toast.makeText;

public class EtapasResponsavel extends AppCompatActivity {

    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    private static Button buttonSalvar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapas_responsavel);
        setTitle("Etapas Responsável");
        onButtonClickListener();

        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(EtapasResponsavel.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        //expandAll();

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                //display it or do something with it
//                Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
//                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it
//                Toast.makeText(getBaseContext(), "Etapa: " + headerInfo.getName(),
//                        Toast.LENGTH_LONG).show();

                return false;
            }
        });


    }

    public void onButtonClickListener(){
        buttonSalvar = (Button)findViewById(R.id.button5);
        buttonSalvar.setOnClickListener(new View.OnClickListener(){
                                            public void onClick(View v){
                                                AlertDialog.Builder a_builder = new AlertDialog.Builder(EtapasResponsavel.this);
                                                a_builder.setMessage("Deseja salvar?")
                                                        .setPositiveButton("OK",new DialogInterface.OnClickListener(){
                                                            public void onClick(DialogInterface dialog, int which){
                                                                //Aqui tem que pegar as checkbox e dar update no banco
                                                                makeText(EtapasResponsavel.this,"Salvo com sucesso!", Toast.LENGTH_LONG).show();
                                                                // makeText(Etapas.this,"Salvo com sucesso!",Toast.LENGTH_LONG).show();
                                                                //sleep(500);
                                                                finish();
                                                            }
                                                        })
                                                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
                                                        {
                                                            public void onClick(DialogInterface dialog, int which){
                                                                dialog.cancel();
                                                            }
                                                        });
                                                AlertDialog alert = a_builder.create();
                                                alert.show();

                                            }
                                        }
        );
    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void loadData() {



        addProduct("Etapa 1", "Marcação da obra",false);
        addProduct("Etapa 1", "Valetas e brocas",false);
        addProduct("Etapa 1", "Alicerce e impermeabilização",false);
        addProduct("Etapa 1", "30 % alvenaria (altura de 1,20m)",false);
        addProduct("Etapa 1", "Contra-verga com canaleta e concreto armado com treliça",false);

        addProduct("Etapa 2", "Final da alvenaria",false);
        addProduct("Etapa 2", "Verga nas portas e janelas com canaleta e concreto armado com treliça",false);
        addProduct("Etapa 2", "Vigas de respaldo",false);
        addProduct("Etapa 2", "Colocação da laje",false);
        addProduct("Etapa 2", "Concretagem da laje",false);
        addProduct("Etapa 2", "Entrada de água e energia e colocação das caixinhas na laje",false);

        addProduct("Etapa 3", "Telhado (pulverizar madeira com cupicida)",false);
        addProduct("Etapa 3", "Elétrica ( eletrodutos e caixinhas nas paredes)",false);
        addProduct("Etapa 3", "Encanamento de água",false);
        addProduct("Etapa 3", "50% encanamento de esgoto e águas pluviais( Colocar Caixa de gordura)",false);
        addProduct("Etapa 3", "70 % chapisco e reboco interno",false);
        addProduct("Etapa 3", "Contra-piso interno",false);

        addProduct("Etapa 4", "Colocar os batentes e as janelas Sassazaki",false);
        addProduct("Etapa 4", "Terminar reboco interno",false);
        addProduct("Etapa 4", "70% reboco e chapisco externo",false);
        addProduct("Etapa 4", "100% azulejo",false);
        addProduct("Etapa 4", "50% piso",false);
        addProduct("Etapa 4", "Início da pintura (Selador nos cômodos liberados)",false);
        addProduct("Etapa 4", "Cimentado externo",false);
        addProduct("Etapa 4", "Final de hidráulica, esgoto",false);

        addProduct("Etapa 5", "Terminar reboco externo",false);
        addProduct("Etapa 5", "Terminar colocação do piso e rodapé; soleiras e peitoris",false);
        addProduct("Etapa 5", "Assentar portas e fechaduras",false);
        addProduct("Etapa 5", "Final da pintura",false);

        addProduct("Etapa 6", "Colocação do vaso sanitário, lavatório, pia e tanque",false);
        addProduct("Etapa 6", "Final da elétrica (enfiação, espelhos das caixinhas)",false);
        addProduct("Etapa 6", "Limpeza geral da casa",false);
        addProduct("Etapa 6", "Retirada do Habite-se",false);
        addProduct("Etapa 6", "Averbação em cartório.",false);

    }


    //here we maintain our products in various departments
    private int addProduct(String department, String product, boolean status) {

        int groupPosition = 0;
        status = false;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        detailInfo.setStatus(false);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
}

