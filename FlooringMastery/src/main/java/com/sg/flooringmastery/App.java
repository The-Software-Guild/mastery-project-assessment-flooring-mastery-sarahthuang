package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FlooringMasteryController;
import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.AuditDaoImpl;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryDaoImpl;
import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.service.FlooringMasteryService;
import com.sg.flooringmastery.service.FlooringMasteryServiceImpl;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOImpl;

public class App {
    public static final String ORDER_FILE = "Orders_06012013.txt";
    public static void main(String[] args) throws FlooringMasteryPersistenceException {
        UserIO io = new UserIOImpl();
        AuditDao adao = new AuditDaoImpl();
        FlooringMasteryDao dao = new FlooringMasteryDaoImpl();
        FlooringMasteryView view = new FlooringMasteryView(io);
        FlooringMasteryService service = new FlooringMasteryServiceImpl(adao, dao);
        FlooringMasteryController controller = new FlooringMasteryController(view, service);
        controller.run();
    }
}
