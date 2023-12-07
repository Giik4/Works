using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptTiro : MonoBehaviour
{

    public float velocidade = 5;
    private Rigidbody2D rbd;
    
    private void OnCollisionEnter2D(Collision2D collision){
        Destroy(this.gameObject);
    }
    
    // Start is called before the first frame update
    void Start()
    {
        rbd = GetComponent<Rigidbody2D>();
        rbd.velocity = new Vector2(-velocidade, 0);
    }

    // Update is called once per frame
    void Update()
    {
        if(transform.position.x < 76f)
            Destroy(this.gameObject);
        
    }
}
