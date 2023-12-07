using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptEspelho : MonoBehaviour
{
   private GameObject espelhoSaida;
   private void OnTriggerEnter(Collider col){
        GameObject obj = col.gameObject;
        if(gameObject.tag == "espelhoEsq"){
            espelhoSaida = GameObject.FindGameObjectWithTag("cameraDir");
        }else{
            espelhoSaida = GameObject.FindGameObjectWithTag("cameraEsq");
        }
       

        if(obj.tag == "Player"){
            obj.transform.position = espelhoSaida.transform.position;
            obj.GetComponent<Rigidbody>().AddForce(obj.transform.forward * 10, ForceMode.Impulse);
        }
   }
   
    
}
