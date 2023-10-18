import java.math.BigDecimal;

public class PC {

    private String cpu;
    private String memory;
    private String graphicsCard;
    private BigDecimal price;

    private BigDecimal cpuCost;
    private BigDecimal memoryCost;
    private BigDecimal graphicsCardCost;


    public PC(String cpu, String memory, String graphicsCard) {
        this.cpu = cpu;
        this.memory = memory;
        this.graphicsCard = graphicsCard;

    }

    public BigDecimal getPrice() {

        this.price = new BigDecimal("800").add(getCpuCost(this.cpu)).add(getGraphicsCardCost(this.graphicsCard)).add(getMemoryCost(this.memory));
        return price;
    }


    public BigDecimal getCpuCost(String cpu) {

        if (cpu.equals("NITEL")) {

            this.cpuCost = new BigDecimal( "300");
        } else if (cpu.equals("DAM")) {
            this.cpuCost = new BigDecimal("250");
        }

        return this.cpuCost;
    }
    public BigDecimal getMemoryCost(String memory) {

        if (memory.equals("8GB")) {

            this.memoryCost = new BigDecimal( "400");
        } else if (memory.equals("16GB")) {
            this.memoryCost = new BigDecimal("700");
        }else if (memory.equals("32GB")) {
            this.memoryCost = new BigDecimal("1000"); }

        return this.memoryCost;
    }

    public BigDecimal getGraphicsCardCost(String graphicsCard) {

        if (graphicsCard.equals("FORCEG")) {

            this.graphicsCardCost = new BigDecimal( "500");
        } else if (graphicsCard.equals("EONRAD")) {
            this.graphicsCardCost = new BigDecimal("350");
        }
        return this.graphicsCardCost;
    }
    @Override
    public String toString(){

        return "-------------------------------- CPU: "+
                cpu+ " | Memory:" + memory + " | Graphics:" + "\n" + graphicsCard + " Total Price: " + price +
    "--------------------------------";
    }

}