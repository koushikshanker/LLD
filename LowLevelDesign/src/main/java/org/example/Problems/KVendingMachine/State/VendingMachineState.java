package org.example.Problems.KVendingMachine.State;

import org.example.Problems.KVendingMachine.Denominations.Coin;
import org.example.Problems.KVendingMachine.Denominations.Note;
import org.example.Problems.KVendingMachine.Product;

public interface VendingMachineState {
    void selectProduct(Product product);

    void insertCoin(Coin coin);

    void insertNote(Note note);

    void dispenseProduct();

    void returnChange();
}
