package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.company.util.Car;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
//import org.primefaces.showcase.domain;

@ManagedBean
public class TabbedView {

    private List<Car> cars;

    @PostConstruct
    public void init() {
        cars = new ArrayList<Car>();
        cars.add(new Car("Y25YIH5", "Fiat", 2014, "Black"));
        cars.add(new Car("JHF261G", "BMW", 2013, "Blue"));
        cars.add(new Car("HSFY23H", "Ford", 2012, "Black"));
        cars.add(new Car("GMDK353", "Volvo", 2014, "White"));
        cars.add(new Car("345GKM5", "Jaguar", 2011, "Gray"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
