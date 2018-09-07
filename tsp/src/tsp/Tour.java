package tsp;

import java.util.ArrayList;
import java.util.Collections;

//每个Tour就是一个旅行路径，种群的一个  个体
public class Tour{

    // 保持所有城市的路径
    private ArrayList tour = new ArrayList<City>();
    // Cache
    private double fitness = 0;
    private int distance = 0;

    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TSP_GA.destinationCities.size(); i++) {
            tour.add(null);
        }
    }

    public Tour(ArrayList tour){
        this.tour = tour;
    }

    //创建一个随机的 个体(路径)
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TSP_GA.destinationCities.size(); cityIndex++) {
          setCity(cityIndex, TSP_GA.destinationCities.get(cityIndex));
        }
        // 打乱顺序
        Collections.shuffle(tour);
    }

    // Gets a city from the tour
    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    // 讲城市加入到路径中
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }

    // 距离小的 适应值较大
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    // 获取当前路径的总距离
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    //一个路径中 城市的个数
    public int tourSize() {
        return tour.size();
    }
    //当前路径中是否包含该city
    public boolean containsCity(City city){
        return tour.contains(city);
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}
