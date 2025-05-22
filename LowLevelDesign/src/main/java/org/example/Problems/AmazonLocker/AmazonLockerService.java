package org.example.Problems.AmazonLocker;

import org.example.Problems.MeetingScheduler.Location;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;

public class AmazonLockerService {

    LockerStrategyService lockerStrategyService;
    OtpGenerationService otpGenerationService;
    User user;
    DeliveryPerson deliveryPerson;
    LockerItem lockerItem;
    Locker locker;
    Slot slot;
    String otp;
    SlotStrategyService slotStrategyService;
    AssignDeliveryPersonStrategy assignDeliveryPersonStrategy;
    public AmazonLockerService()
    {
        user = new User(1,"Ramesh","9908");
        deliveryPerson = new DeliveryPerson(1,"Suresh","9901");
        slot = new Slot(1,"slot1","L");
        locker = new Locker(1,"hydlocker","HYDERABAD");
        locker.addSlot(slot);
        lockerItem = new LockerItem(1,"lockerItem");
        lockerStrategyService = new LockerStrategyService();
        otpGenerationService = new OtpGenerationService();
        lockerStrategyService.addLocker(locker);
        assignDeliveryPersonStrategy = new AssignDeliveryPersonStrategy();
        assignDeliveryPersonStrategy.addDeliveryPerson(deliveryPerson);
    }
   public void run()
   {



       // user order a item
       userOrdersLockerItem(user, lockerItem, "HYDERABAD");

       //delivery person delivers locker item to locker
       itemDeliveredToLocker(locker,lockerItem, slot, otp);

       //user picks order from locker
       userPicksOrderFromLocker(user, locker,slot,otp);

       //user will initiate a return
       userReturnOrder(user,"location",lockerItem);

       //deliveryPerson will collect item
       deliveryPersonPicksOrderFromLocker(deliveryPerson,locker,slot,otp);

   }

    private void userReturnOrder(User user, String location, LockerItem lockerItem) {
        System.out.println("User returned order to locker");
        System.out.println("--------------------------------");
        locker = lockerStrategyService.getLocker();
        slotStrategyService = new SlotStrategyService(locker);
        lockerItem.setLocker(locker);
        slot = slotStrategyService.getSlot();
        lockerItem.setSlot(slot);
        otp = otpGenerationService.generateOtp();
        NotifyUser(user,locker,slot,otp);
        itemDeliveredToLocker(locker,lockerItem,slot,otp);
       deliveryPerson = assignDeliveryPersonStrategy.getDeliveryPerson(lockerItem,location);
        NotifyUser(deliveryPerson,locker,slot,otp);
        slot.setOtp(otp);
    }




    public void userOrdersLockerItem(User user, LockerItem lockerItem, String location)
   {
       System.out.println("User orders an item");
       System.out.println("--------------------------------");
       locker = lockerStrategyService.getLocker();
       System.out.println("locker is assigned");
       System.out.println("--------------------------------");
       slotStrategyService = new SlotStrategyService(locker);
       lockerItem.setLocker(locker);
       slot = slotStrategyService.getSlot();
       System.out.println("slot is assigned");
       System.out.println("--------------------------------");
       lockerItem.setSlot(slot);
       otp = otpGenerationService.generateOtp();
       deliveryPerson = assignDeliveryPersonStrategy.getDeliveryPerson(lockerItem,location);
       System.out.println("Delivery person is assigned");
       System.out.println("--------------------------------");
       NotifyUser(deliveryPerson,locker,slot,otp);
       slot.setOtp(otp);
   }

    private void itemDeliveredToLocker(Locker locker, LockerItem lockerItem , Slot slot, String otp) {
        if((lockerItem.getLocker()== locker) && Objects.equals(slot.getOtp(), otp))
        {
            System.out.println("locker item is delivered to locker: locker");
            System.out.println("--------------------------------");
            slot.setLockerItem(lockerItem);
            otp = otpGenerationService.generateOtp();
            NotifyUser(user,locker,slot,otp);
        }
        else
        {
            throw new RuntimeException("wrong otp entered by delivery person");
        }
    }

    private void userPicksOrderFromLocker(User user, Locker locker, Slot slot, String otp) {
        if(Objects.equals(slot.getOtp(), otp))
        {

            System.out.println("User picked item from locker");
            System.out.println("--------------------------------");
            slot.setStatus(SlotStatus.FREE);
        }
        else
        {
            throw new RuntimeException("wrong otp entered by delivery person");
        }
    }
    private void deliveryPersonPicksOrderFromLocker(DeliveryPerson deliveryPerson, Locker locker, Slot slot, String otp) {
        if(Objects.equals(slot.getOtp(), otp))
        {
            System.out.println("User received item");
            System.out.println("--------------------------------");
            slot.setStatus(SlotStatus.FREE);
        }
        else
        {
            throw new RuntimeException("wrong otp entered by delivery person");
        }
    }
    private void NotifyUser(DeliveryPerson deliveryPerson, Locker locker, Slot slot, String otp) {
        System.out.println("Notified delivery person with locker with slot with otp");
        System.out.println("--------------------------------");
    }

    private void NotifyUser(User user, Locker locker, Slot slot, String otp) {
        System.out.println("Notified user with locker with slot with otp");
        System.out.println("--------------------------------");
    }
}
