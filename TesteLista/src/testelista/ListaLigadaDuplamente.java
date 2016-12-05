package testelista;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @authores Amanda, Guilherme, Julielen, Wilson
 * @param <T>
 */
public class ListaLigadaDuplamente<T> implements List<T>, Serializable, Iterator {

    private No<T> inicio;
    private No<T> fim;
    private int indice;
    private int size;

    public ListaLigadaDuplamente() {
        this.inicio = null;
        this.fim = null;
        this.indice = 0;
        this.size = 0;
    }
/**
 * 
 * @return 
 */
    @Override
    public int size() {
        return this.getSize();
    }
/**
 * 
 * @return 
 */
    @Override
    public boolean isEmpty() {
        return this.getInicio() == null;
    }
    
    /**
     * 
     * @return 
     */
    public T getLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            return (T) getFim().getInfo();
        }
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean contains(Object o) {

        No<T> p = new No(null);

        if (o == null) {

            throw new NullPointerException("Objeto é nulo, não é possivél verificar na lista.");
        } else {
            No<T> aux = this.inicio;
            while ((aux != null) || (aux.getProximo() != this.inicio)) {
                if (aux.getInfo() == o) {
                    return true;
                }
                aux = aux.getProximo();
            }
            return false;
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Iterator iterator() {
        indice = 0;
        return this;
    }

    
    
    /**
    * Metodo que adciona objetos na lista a partir do zero
    * Adiciona mesmo que nao tenha nada na lista ainda
    * Verifica se existe um objeto na lista,
    * se não existe ele cria.
    * Se já existe ele adciona no final da lista.
    * @param e
    * @return 
    */
    @Override
    public boolean add(T e) {
        No<T> aux;
        if (!this.isEmpty()) {
            aux = new No(getIndice(), e, getInicio(), getFim());
            this.getFim().setProximo(aux);
            this.setFim(aux);
            this.getInicio().setAnterior(getFim());
        } else {
            this.setInicio(new No(getIndice(), e, getInicio(), getInicio()));
            this.getInicio().setAnterior(getInicio());
            this.getInicio().setProximo(getInicio());
            this.setFim(getInicio());
        }

        this.setIndice(this.getIndice() + 1);
        this.setSize(this.getSize() + 1);
        return true;
    }
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean remove(Object o) {

        No<T> aux;
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {

            aux = this.inicio;
            while (aux != this.fim) {
                if (o == aux.getInfo()) {
                    No<T> anterior = null;
                    No<T> proximo = null;
                } else {

                    aux = aux.getProximo();

                }

                No<T> anterior = aux.getAnterior();
                No<T> proximo = aux.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                this.size--;
                this.decrementarLista(proximo);
                return true;

            }
        }
        return false;
    }

    
    /**
     * Método que pega o Imovel da lista e retorna ele
     * @param i
     * @return imovel
     */ 
    @Override
    public T get(int i) {
        
        //falta tratar as Execptions IndexOfOut..
        No<T> aux = this.getInicio();

        for (int j = 0; j < i; j++) {
            aux = aux.getProximo();
        }
        return (T) aux.getInfo();
    }

    /**
     * @return the inicio
     */
    public No getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public No getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(No fim) {
        this.fim = fim;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * 
     * @param i
     * @param e
     * @return 
     */
    @Override
    public T set(int i, T e) {

        if (e == null) {

            throw new NullPointerException("Objeto é nulo, não pode ser salvo na lista.");
        } else if (i < 0 || i >= size()) {

            throw new IndexOutOfBoundsException("Valor fora do intervalo válido.");

        } else {
            No<T> aux = this.getInicio();
            T obj;

            for (int j = 0; j < i; j++) {
                aux = aux.getAnterior();

            }
            obj = aux.getInfo();
            aux.setInfo(e);
            return obj;
        }

    }

    /**
    * Metodo que funciona se ja existe algum objeto na lista de imoveis
    * 
    * @param index
    * @param element 
    */
    @Override
    public void add(int index, T element) {
        int numElements = 0;
		if (index < 0 || index > numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		if (index == 0) {
			add(element);
			return;
		}
                No<T> aux = new No(indice, element, this.fim.getProximo(), this.fim);
                this.fim.setProximo(aux);
                this.fim = aux;
                this.inicio.setAnterior(fim);
		numElements++;

	}
    
    /**
    * Método que remove um imovel da lista
    * @param index
    * @return 
    *  
    */
    @Override
    public T remove(int index) {
        No aux = this.inicio;
        Object aux1;
        if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("" + index);
		}
		if(size() == 1){
                    aux1 = inicio.getInfo();
                    setInicio(null);
                    setFim(null);
                    inicio.setProximo(null);
                    inicio.setAnterior(null);
                    fim.setAnterior(null);
                    fim.setProximo(null);
                           
                } else{
                     
                    for (int i=0; i<index; i++) {
                        aux=aux.getProximo();
                    }                   
                    aux.setProximo(aux.getAnterior());
                    aux.setAnterior(aux.getProximo());
                    
                    }
                return (T) aux;                
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int indexOf(Object o) {

        if (o == null) {

            throw new NullPointerException("Objeto informado é nulo");

        } else if (isEmpty()) {

            throw new NullPointerException("Lista vazia");
        } else {

            int cont = 0;

            if (inicio.getInfo().equals(o)) {

                return cont;

            }

            if (!(inicio.getAnterior().getInfo().equals(inicio))) {
                No aux = inicio.getProximo();

                cont++;

                while (!aux.equals(inicio)) {

                    if (aux.getInfo().equals(o)) {

                        return cont;
                    }
                    aux = aux.getProximo();

                    cont++;

                }

            }

        }

        return -1;

    }

    /**
     * Método que decrementa a Lista
     *
     * @param n
     */
    private void decrementarLista(No n) {
        if (this.size == 1) {
            this.fim = inicio;
        }
        this.indice--;
        No aux = n;
        while (aux != this.fim) {
            aux.decrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();
    }

    /**
     * Método que incrementa a Lista
     *
     * @param n
     */
    private void incrementarLista(No n) {
        this.indice++;
        No aux = n;
        while (aux != this.fim) {
            aux.IncrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();

    }
    
    @Override
    public boolean hasNext() {
        return indice < size;
    }

    @Override
    public T next() {
        T a = get(indice++);
        return a;

    }
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
