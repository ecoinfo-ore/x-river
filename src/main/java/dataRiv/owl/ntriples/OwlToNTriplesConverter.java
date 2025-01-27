
package dataRiv.owl.ntriples ;

/**
 *
 * @author ryahiaoui
 */

import java.io.File ;
import java.io.FileOutputStream ;
import java.io.FileNotFoundException ;
import org.apache.logging.log4j.Logger ;
import org.apache.jena.rdf.model.Model ;
import org.apache.logging.log4j.LogManager ;
import org.apache.jena.ontology.OntModelSpec ;
import org.apache.jena.rdf.model.ModelFactory ;

public class OwlToNTriplesConverter {

    final  static Logger LOGGER  = LogManager.getLogger( OwlToNTriplesConverter.class.getName( )) ;
  
    public static void convert( String owlPath, String outPathFile ) throws FileNotFoundException {
        
      LOGGER.info("Reading Ontolgy File : " + owlPath )          ;
      
      OntModelSpec spec = OntModelSpec.OWL_DL_MEM_RDFS_INF       ;
 
      Model model       = ModelFactory.createOntologyModel(spec) ;
      
      model.read( owlPath ) ;
      
      File file            = new File ( outPathFile )            ;
      FileOutputStream fop = new FileOutputStream( file  )       ;

      LOGGER.info( "Writing Ontology in [ TTL ] Format at : "    + 
                   outPathFile                              )    ;
      
      model.write( fop , "NT" ) ;
    
      LOGGER.info( "DONE !  " ) ;
      
    }
}

