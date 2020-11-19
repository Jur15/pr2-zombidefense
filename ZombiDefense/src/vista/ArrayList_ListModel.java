package vista;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author moral
 */
public class ArrayList_ListModel<E> extends AbstractListModel<E> {

    private ArrayList<E> lista = new ArrayList<>();

    public ArrayList_ListModel(ArrayList<E> data) {
        lista = data;
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public E getElementAt(int index) {
        return lista.get(index);
    }

}
