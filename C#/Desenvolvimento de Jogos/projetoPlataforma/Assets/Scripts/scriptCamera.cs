using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptCamera : MonoBehaviour
{
    public GameObject pc;
    public float offset_y = 2;
    public float offset_x = 0;
    public float alturaMin = -2;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        seguirPlayer();
        controle();
    }

    private void seguirPlayer(){
        Vector3 posicao = new Vector3(pc.transform.position.x + offset_x, pc.transform.position.y+ offset_y, -10);

        this.transform.position = posicao;
    }

    private void controle(){
        if(pc.transform.position.y < alturaMin){
            Vector3 posicao = new Vector3(pc.transform.position.x + offset_x, alturaMin, -10);
        this.transform.position = posicao;
        }
    }
}
