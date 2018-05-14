/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValorObjeto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Gama
 */
public class ClienteVO {

    private int id_customer;
    private String cpf_cnpj;
    private String nm_custumer;
    private boolean is_active;
    private float vl_total;

    

    public ClienteVO(String cpf_cnpj, String nm_custumer, boolean is_active, float vl_total) 
    {
        this.cpf_cnpj = cpf_cnpj;
        this.nm_custumer = nm_custumer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    public ClienteVO()
    {

    }

    /**
     * @return the id_customer
     */
    public int getId_customer() {
        return id_customer;
    }

    /**
     * @return the cpf_cnpj
     */
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    /**
     * @param cpf_cnpj the cpf_cnpj to set
     */
    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    /**
     * @return the nm_custumer
     */
    public String getNm_custumer() {
        return nm_custumer;
    }

    /**
     * @param nm_custumer the nm_custumer to set
     */
    public void setNm_custumer(String nm_custumer) {
        this.nm_custumer = nm_custumer;
    }

    /**
     * @return the is_active
     */
    public boolean isIs_active() {
        return is_active;
    }

    /**
     * @param is_active the is_active to set
     */
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    /**
     * @return the vl_total
     */
    public float getVl_total() {
        return vl_total;
    }

    /**
     * @param vl_total the vl_total to set
     */
    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

    /**
     * @param id_customer the id_customer to set
     */
    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }




}
