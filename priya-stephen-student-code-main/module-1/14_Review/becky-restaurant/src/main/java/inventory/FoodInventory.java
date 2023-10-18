package inventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodInventory {
    private List<Avocados> avocados;
    private List<Beans> beansList;
    private List<Broccoli> broccoliList;
    private List<Chicken> chickenList;
    private List<Rice> riceList;
    public BigDecimal initialCost;

    public FoodInventory(){
        avocados = new ArrayList<>();
        beansList = new ArrayList<>();
        broccoliList = new ArrayList<>();
        chickenList = new ArrayList<>();
        riceList = new ArrayList<>();
    }

    public void addAvocado(Avocados avo){
        avocados.add(avo);
    }

    public void addBeans(Beans beans){
        beansList.add(beans);
    }

    public void addBroccoli(Broccoli broccoli){
        broccoliList.add(broccoli);
    }

    public void addChicken(Chicken chicken){
        chickenList.add(chicken);
    }

    public void addRic(Rice rice){
        riceList.add(rice);
    }

    public BigDecimal getTotalInventoryCost(){
        BigDecimal totalInventoryCost = BigDecimal.ZERO;

        for(Avocados eachAvocado : avocados){
            totalInventoryCost.add(eachAvocado.getInitialCost());
        }

        for(Beans eachBean : beansList){
            totalInventoryCost.add(eachBean.getInitialCost());
        }

        for(Broccoli eachBroccoli : broccoliList){
            totalInventoryCost.add(eachBroccoli.getInitialCost());
        }

        for(Chicken eachChicken : chickenList){
            totalInventoryCost.add(eachChicken.getInitialCost());
        }

        for(Rice eachRice : riceList){
            totalInventoryCost.add(eachRice.getInitialCost());
        }

        return totalInventoryCost;
    }
}
