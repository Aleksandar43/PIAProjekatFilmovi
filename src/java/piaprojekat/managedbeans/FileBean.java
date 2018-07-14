/* */
package piaprojekat.managedbeans;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@RequestScoped
public class FileBean {
    private UploadedFile file;
    private String sadrzaj;
    private byte[] sadrzaj2;
    public FileBean() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public byte[] getSadrzaj2() {
        return sadrzaj2;
    }

    public void setSadrzaj2(byte[] sadrzaj2) {
        this.sadrzaj2 = sadrzaj2;
    }
    
    public void ucitaj(){

//            InputStream inputstream = file.getInputstream();
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputstream);
            sadrzaj2=file.getContents();

    }
}
